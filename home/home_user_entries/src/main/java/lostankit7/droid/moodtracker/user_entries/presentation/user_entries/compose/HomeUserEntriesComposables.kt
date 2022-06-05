package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import lostankit7.droid.moodtracker.core_ui.compose.view.Chip
import lostankit7.droid.moodtracker.core_ui.utils.spacing
import lostankit7.droid.moodtracker.user_entries.presentation.user_entries.viewmodel.UserEntriesViewModel

@Composable
fun DrawUserEntryScreen(viewModel: UserEntriesViewModel) {
    val state = viewModel.state
    val entries = viewModel.userEntries().observeAsState(emptyList()).value

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(entries.size) { index ->

            val currItem = entries[index].date
            val prevItem = entries.getOrNull(index - 1)?.date
            val dateHeader = if (currItem == prevItem) null else currItem

            dateHeader?.let {
                Spacer(modifier = Modifier.size(spacing.dp_10))
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Chip(value = it, modifier = Modifier.align(Alignment.Center))
                }
            }

            Spacer(modifier = Modifier.size(spacing.dp_10))
            DrawUserEntryItem(entries[index])
        }
    }
}