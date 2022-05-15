package lostankit7.android.entry_domain.repository

import kotlinx.coroutines.flow.Flow
import lostankit7.android.entry_domain.entities.UserEntry

interface UserEntriesRepository {
    val userEntries: Flow<List<UserEntry>>
    fun userEntries(date: String): Flow<List<UserEntry>>
    suspend fun saveUserEntry(userEntry: UserEntry)
    suspend fun deleteUserEntry(userEntry: UserEntry)
    suspend fun updateUserEntry(userEntry: UserEntry)
}