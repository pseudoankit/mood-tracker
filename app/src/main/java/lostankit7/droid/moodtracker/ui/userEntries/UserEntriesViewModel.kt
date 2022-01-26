package lostankit7.droid.moodtracker.ui.userEntries

import androidx.lifecycle.ViewModel
import lostankit7.droid.moodtracker.base.BaseViewModel
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import lostankit7.droid.moodtracker.data.repository.UserEntriesRepository
import javax.inject.Inject

class UserEntriesViewModel @Inject constructor(
    private val repository: UserEntriesRepository
) : BaseViewModel() {

    val userEntries = repository.userEntries

    fun deleteUserEntry(userEntry: UserEntry) = launchIo{ repository.deleteUserEntry(userEntry) }

    fun updateUserEntry(userEntry: UserEntry) = launchIo{ repository.updateUserEntry(userEntry) }
}