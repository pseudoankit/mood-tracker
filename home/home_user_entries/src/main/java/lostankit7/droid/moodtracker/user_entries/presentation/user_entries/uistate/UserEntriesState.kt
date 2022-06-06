package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.uistate

import lostankit7.android.entry_domain.entities.UserEntry

data class UserEntriesState(
    val entries: List<UserEntry.Entry> = emptyList(),
    val isLoading: Boolean = false,
) {
    val emptyState get() = entries.isEmpty()
}