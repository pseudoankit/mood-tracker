package lostankit7.droid.moodtracker.data.repository

import androidx.lifecycle.LiveData
import lostankit7.droid.moodtracker.data.database.dao.UserEntryDao
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import javax.inject.Inject

class UserEntriesRepository @Inject constructor(dao: UserEntryDao) {

    val userEntries: LiveData<MutableList<UserEntry>> = dao.userEntries()

}
