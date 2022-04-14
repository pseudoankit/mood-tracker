package lostankit7.droid.moodtracker.ui.viewmodel

import lostankit7.droid.moodtracker.base.viewmodel.BaseViewModel
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import lostankit7.droid.moodtracker.data.repository.UserEntriesRepository
import javax.inject.Inject

class UserEntriesViewModel @Inject constructor(
    private val repository: UserEntriesRepository
) : BaseViewModel() {

    val userEntries = repository.userEntries

    fun userEntries(date: String) = repository.userEntries(date)

    fun deleteUserEntry(userEntry: UserEntry) = launchIo{ repository.deleteUserEntry(userEntry) }

    fun updateUserEntry(userEntry: UserEntry) = launchIo{ repository.updateUserEntry(userEntry) }
}