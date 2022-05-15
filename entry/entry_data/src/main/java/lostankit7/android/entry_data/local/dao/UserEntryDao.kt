package lostankit7.android.entry_data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import lostankit7.android.entry_data.local.entities.LocalUserEntry

@Dao
interface UserEntryDao {

    @Query("SELECT * FROM LocalUserEntry")
    fun userEntries(): Flow<List<LocalUserEntry>>

    @Query("SELECT * FROM LocalUserEntry WHERE date = :date")
    fun userEntries(date: String): Flow<List<LocalUserEntry>>

    @Insert
    suspend fun saveUserEntry(userEntry: LocalUserEntry)

    @Delete
    suspend fun deleteUserEntry(userEntry: LocalUserEntry)

    @Update
    suspend fun updateUserEntry(userEntry: LocalUserEntry)
}