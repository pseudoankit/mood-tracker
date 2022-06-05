package lostankit7.android.entry_domain.repository

import androidx.lifecycle.LiveData
import lostankit7.android.entry_domain.entities.UserEntry

interface UserEntriesRepository {
    fun userEntries(): LiveData<List<UserEntry>>
    fun userEntries(date: String): LiveData<List<UserEntry>>
    suspend fun saveUserEntry(userEntry: UserEntry)
    suspend fun deleteUserEntry(userEntry: UserEntry)
    suspend fun updateUserEntry(userEntry: UserEntry)
}