package lostankit7.droid.moodtracker.presentation.viewmodel

import lostankit7.droid.moodtracker.core_presentation.viewmodel.BaseViewModel
import lostankit7.android.entry_data.database.entities.UserEntry
import lostankit7.android.entry_data.repository.UserEntriesRepository
import javax.inject.Inject

class UserEntriesViewModel @Inject constructor(
    private val repository: lostankit7.android.entry_data.repository.UserEntriesRepository
) : BaseViewModel() {

    val allEntriesLiveData = repository.userEntries

    fun singleDateUserEntries(date: String) = repository.userEntries(date)

    fun deleteUserEntry(userEntry: lostankit7.android.entry_data.database.entities.UserEntry) = launchIo{ repository.deleteUserEntry(userEntry) }

    fun updateUserEntry(userEntry: lostankit7.android.entry_data.database.entities.UserEntry) = launchIo{ repository.updateUserEntry(userEntry) }
}