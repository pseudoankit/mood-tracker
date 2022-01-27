package lostankit7.droid.moodtracker.data.repository

import androidx.lifecycle.LiveData
import lostankit7.droid.moodtracker.data.database.dao.UserEntryDao
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import javax.inject.Inject

class UserEntriesRepository @Inject constructor(private val dao: UserEntryDao) {

    val userEntries: LiveData<MutableList<UserEntry>> = dao.userEntries()

    fun userEntries(date: String) = dao.userEntries(date)

    suspend fun saveUserEntry(userEntry: UserEntry) = dao.saveUserEntry(userEntry)

    suspend fun deleteUserEntry(userEntry: UserEntry) = dao.deleteUserEntry(userEntry)

    suspend fun updateUserEntry(userEntry: UserEntry) = dao.updateUserEntry(userEntry)
}
