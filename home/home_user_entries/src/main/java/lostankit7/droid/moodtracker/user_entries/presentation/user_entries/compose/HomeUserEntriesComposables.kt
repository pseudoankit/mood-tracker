package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import lostankit7.droid.moodtracker.user_entries.presentation.user_entries.viewmodel.UserEntriesViewModel

@Composable
fun DrawUserEntryScreen(viewModel: UserEntriesViewModel) {
    val state = viewModel.state
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(state.userEntries.size) { index ->
            DrawUserEntryItem(
                state.userEntries[index]
            )
        }
    }
}