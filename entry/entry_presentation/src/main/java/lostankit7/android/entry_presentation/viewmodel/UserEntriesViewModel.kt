package lostankit7.android.entry_presentation.viewmodel

import lostankit7.droid.moodtracker.core_presentation.viewmodel.BaseViewModel
import lostankit7.android.entry_domain.entities.UserEntry
import lostankit7.android.entry_domain.repository.UserEntriesRepository
import javax.inject.Inject

class UserEntriesViewModel @Inject constructor(
    private val repository: UserEntriesRepository,
) : BaseViewModel() {

    val allEntriesLiveData = repository.userEntries

    fun singleDateUserEntries(date: String) = repository.userEntries(date)

    fun deleteUserEntry(userEntry: UserEntry) = launchIo { repository.deleteUserEntry(userEntry) }

    fun updateUserEntry(userEntry: UserEntry) = launchIo { repository.updateUserEntry(userEntry) }
}