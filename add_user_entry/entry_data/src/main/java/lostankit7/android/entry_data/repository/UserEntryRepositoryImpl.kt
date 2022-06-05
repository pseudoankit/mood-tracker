package lostankit7.android.entry_data.repository

import androidx.lifecycle.map
import lostankit7.android.entry_data.local.dao.UserEntryDao
import lostankit7.android.entry_data.mapper.UserEntryMapper.toLocalUserEntryInsert
import lostankit7.android.entry_data.mapper.UserEntryMapper.toLocalUserEntryUpdate
import lostankit7.android.entry_data.mapper.UserEntryMapper.toUserEntry
import lostankit7.android.entry_domain.entities.UserEntry
import lostankit7.android.entry_domain.entities.UserEntry.Entry.Companion.sort
import lostankit7.android.entry_domain.repository.UserEntriesRepository

class UserEntryRepositoryImpl(private val dao: UserEntryDao) : UserEntriesRepository {

    override fun userEntries() = dao.userEntries().map { it.toUserEntry.sort }

    override fun userEntries(date: String) = dao.userEntries(date).map { it.toUserEntry }

    override suspend fun saveUserEntry(entry: UserEntry.Entry) =
        dao.saveUserEntry(entry.toLocalUserEntryInsert)

    override suspend fun deleteUserEntry(entry: UserEntry.Entry) =
        dao.deleteUserEntry(entry.toLocalUserEntryUpdate)

    override suspend fun updateUserEntry(entry: UserEntry.Entry) =
        dao.updateUserEntry(entry.toLocalUserEntryUpdate)
}
