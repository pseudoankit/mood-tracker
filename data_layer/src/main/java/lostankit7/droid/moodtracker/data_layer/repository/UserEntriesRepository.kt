package lostankit7.droid.moodtracker.data_layer.repository

import androidx.lifecycle.LiveData
import lostankit7.droid.moodtracker.data_layer.database.dao.UserEntryDao
import lostankit7.droid.moodtracker.data_layer.database.entities.UserEntry
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserEntriesRepository @Inject constructor(private val dao: UserEntryDao) {

    val userEntries: LiveData<MutableList<UserEntry>> = dao.userEntries()

    fun userEntries(date: String) = dao.userEntries(date)

    suspend fun saveUserEntry(userEntry: UserEntry) = dao.saveUserEntry(userEntry)

    suspend fun deleteUserEntry(userEntry: UserEntry) = dao.deleteUserEntry(userEntry)

    suspend fun updateUserEntry(userEntry: UserEntry) = dao.updateUserEntry(userEntry)
}
