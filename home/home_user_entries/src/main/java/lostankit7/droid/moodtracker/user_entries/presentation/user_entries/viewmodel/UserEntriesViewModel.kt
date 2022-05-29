package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.viewmodel

import lostankit7.android.entry_domain.repository.UserEntriesRepository
import lostankit7.droid.moodtracker.core.domain.entities.shared.UserEntry
import lostankit7.droid.moodtracker.core.presentation.base.viewmodel.BaseViewModel
import javax.inject.Inject

class UserEntriesViewModel @Inject constructor(
    private val repository: UserEntriesRepository,
) : BaseViewModel() {

    val allEntriesLiveData get() = repository.userEntries()

    fun singleDateUserEntries(date: String) = repository.userEntries(date)

    fun deleteUserEntry(userEntry: UserEntry) = launchIo { repository.deleteUserEntry(userEntry) }

    fun updateUserEntry(userEntry: UserEntry) = launchIo { repository.updateUserEntry(userEntry) }
}