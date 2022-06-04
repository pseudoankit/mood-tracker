package lostankit7.android.entry_data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import lostankit7.android.entry_data.local.entities.LocalUserEntry

@Dao
interface UserEntryDao {

    @Query("SELECT * FROM LocalUserEntry")
    fun userEntries(): LiveData<List<LocalUserEntry>>

    @Query("SELECT * FROM LocalUserEntry WHERE date = :date")
    fun userEntries(date: String): LiveData<List<LocalUserEntry>>

    @Insert
    suspend fun saveUserEntry(userEntry: LocalUserEntry)

    @Delete
    suspend fun deleteUserEntry(userEntry: LocalUserEntry)

    @Update
    suspend fun updateUserEntry(userEntry: LocalUserEntry)
}