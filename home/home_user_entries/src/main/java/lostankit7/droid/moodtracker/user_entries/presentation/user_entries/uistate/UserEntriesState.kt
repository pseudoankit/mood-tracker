package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.uistate

import lostankit7.droid.moodtracker.core.domain.entities.shared.UserEntry

data class UserEntriesState(
    val userEntries: List<UserEntry> = emptyList(),
    val isLoading: Boolean = false,
) {
    val emptyState get() = userEntries.isEmpty()
}