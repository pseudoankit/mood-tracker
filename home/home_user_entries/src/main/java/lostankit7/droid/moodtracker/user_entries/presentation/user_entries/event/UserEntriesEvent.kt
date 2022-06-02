package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.event

import lostankit7.droid.moodtracker.core.domain.entities.shared.UserEntry

sealed class UserEntriesEvent {
    data class ActionDelete(val userEntry: UserEntry) : UserEntriesEvent()
    object Refresh : UserEntriesEvent()
}