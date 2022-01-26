package lostankit7.droid.moodtracker.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import lostankit7.droid.moodtracker.data.database.entities.UserEntry

@Dao
interface UserEntryDao {

    @Query("SELECT * FROM UserEntry")
    fun userEntries(): LiveData<MutableList<UserEntry>>

    @Insert
    suspend fun saveUserEntry(userEntry: UserEntry)

    @Delete
    suspend fun deleteUserEntry(userEntry: UserEntry)

    @Update
    suspend fun updateUserEntry(userEntry: UserEntry)
}