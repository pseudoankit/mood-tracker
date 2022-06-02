package lostankit7.android.entry_domain.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import lostankit7.droid.moodtracker.core.domain.entities.shared.UserEntry

interface UserEntriesRepository {
    fun userEntries(): Flow<List<UserEntry>>
    fun userEntries(date: String): LiveData<List<UserEntry>>
    suspend fun saveUserEntry(userEntry: UserEntry)
    suspend fun deleteUserEntry(userEntry: UserEntry)
    suspend fun updateUserEntry(userEntry: UserEntry)
}