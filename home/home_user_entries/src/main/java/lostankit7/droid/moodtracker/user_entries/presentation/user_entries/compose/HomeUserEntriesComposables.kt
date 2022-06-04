package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import lostankit7.droid.moodtracker.user_entries.presentation.user_entries.viewmodel.UserEntriesViewModel

@Composable
fun DrawUserEntryScreen(viewModel: UserEntriesViewModel) {
    val state = viewModel.state
    val entries = viewModel.userEntries().observeAsState(emptyList()).value

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(entries.size) { index ->
            DrawUserEntryItem(
                entries[index]
            )
        }
    }
}