package lostankit7.android.entry_domain.repository

import androidx.lifecycle.LiveData
import lostankit7.android.entry_domain.entities.UserEntry

interface UserEntriesRepository {
    fun userEntries(): LiveData<List<UserEntry.Entry>>
    fun userEntries(date: String): LiveData<List<UserEntry.Entry>>
    suspend fun saveUserEntry(entry: UserEntry.Entry)
    suspend fun deleteUserEntry(entry: UserEntry.Entry)
    suspend fun updateUserEntry(entry: UserEntry.Entry)
}