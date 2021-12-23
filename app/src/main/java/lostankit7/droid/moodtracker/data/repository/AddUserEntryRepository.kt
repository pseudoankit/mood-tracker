package lostankit7.droid.moodtracker.data.repository

import lostankit7.droid.moodtracker.data.database.dao.UserEntryDao
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import javax.inject.Inject

class AddUserEntryRepository @Inject constructor(private val dao: UserEntryDao) {

    suspend fun saveUserEntry(userEntry: UserEntry) = dao.saveUserEntry(userEntry)

}
