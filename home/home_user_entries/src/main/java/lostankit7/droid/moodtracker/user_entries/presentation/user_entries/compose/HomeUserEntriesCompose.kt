package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import lostankit7.android.entry_domain.entities.UserEntry
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
            when (val entry = entries[index]) {
                is UserEntry.Date -> {
                    Spacer(modifier = Modifier.size(spacing.dp_10))
                    DrawHeaderDate(entry.date)
                }
                is UserEntry.Entry -> {
                    DrawUserEntryItem(
                        currItem = entry,
                        prevItem = entries.getOrNull(index - 1)
                    )
                    CloseBoxIfLastEntryOfSameDate(entries, index)
                }
            }

            if (index == entries.size - 1) Spacer(modifier = Modifier.size(spacing.dp_10))
        }
    }
}

@Composable
private fun CloseBoxIfLastEntryOfSameDate(list: List<UserEntry>, index: Int) {
    val nextItem = list.getOrNull(index + 1)
    if (nextItem != null && nextItem !is UserEntry.Date) return

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(spacing.dp_2),
        shape = RoundedCornerShape(
            bottomEnd = spacing.cornerRadius,
            bottomStart = spacing.cornerRadius
        )
    ) {}
}

@Composable
private fun DrawHeaderDate(date: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(
            topStart = spacing.cornerRadius,
            topEnd = spacing.cornerRadius
        ),
        elevation = spacing.elevationLow
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = spacing.dp_4)
        ) {
            Text(text = date, modifier = Modifier.align(Alignment.Center))
        }
    }
}