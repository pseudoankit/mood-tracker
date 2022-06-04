package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import lostankit7.android.entry_domain.repository.UserEntriesRepository
import lostankit7.droid.moodtracker.core.domain.entities.shared.UserEntry
import lostankit7.droid.moodtracker.core.presentation.base.viewmodel.BaseViewModel
import lostankit7.droid.moodtracker.user_entries.presentation.user_entries.event.UserEntriesEvent
import lostankit7.droid.moodtracker.user_entries.presentation.user_entries.uistate.UserEntriesState
import javax.inject.Inject

class UserEntriesViewModel @Inject constructor(
    private val repository: UserEntriesRepository,
) : BaseViewModel() {

    var state by mutableStateOf(UserEntriesState())
        private set

    fun onEvent(event: UserEntriesEvent) {
        when (event) {
            is UserEntriesEvent.ActionDelete -> TODO()
            is UserEntriesEvent.Refresh -> TODO("correct execution")
        }
    }

    fun userEntries() = repository.userEntries()

    fun singleDateUserEntries(date: String) = repository.userEntries(date)

    fun deleteUserEntry(userEntry: UserEntry) = launchIo { repository.deleteUserEntry(userEntry) }

    fun updateUserEntry(userEntry: UserEntry) = launchIo { repository.updateUserEntry(userEntry) }
}