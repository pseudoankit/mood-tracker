package lostankit7.android.entry_data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import lostankit7.android.entry_data.local.dao.UserEntryDao
import lostankit7.android.entry_data.mapper.UserEntryMapper.toLocalUserEntryInsert
import lostankit7.android.entry_data.mapper.UserEntryMapper.toLocalUserEntryUpdate
import lostankit7.android.entry_data.mapper.UserEntryMapper.toUserEntry
import lostankit7.android.entry_domain.repository.UserEntriesRepository
import lostankit7.droid.moodtracker.core.domain.entities.shared.UserEntry

class UserEntryRepositoryImpl(private val dao: UserEntryDao) : UserEntriesRepository {

    override fun userEntries(): LiveData<List<UserEntry>> = dao.userEntries().map { it.toUserEntry }

    override fun userEntries(date: String) = dao.userEntries(date).map { it.toUserEntry }

    override suspend fun saveUserEntry(userEntry: UserEntry) =
        dao.saveUserEntry(userEntry.toLocalUserEntryInsert)

    override suspend fun deleteUserEntry(userEntry: UserEntry) =
        dao.deleteUserEntry(userEntry.toLocalUserEntryUpdate)

    override suspend fun updateUserEntry(userEntry: UserEntry) =
        dao.updateUserEntry(userEntry.toLocalUserEntryUpdate)
}
