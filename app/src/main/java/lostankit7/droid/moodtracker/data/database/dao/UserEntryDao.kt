package lostankit7.droid.moodtracker.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import lostankit7.droid.moodtracker.data.database.entities.UserEntry

@Dao
interface UserEntryDao {

    @Query("SELECT * FROM UserEntry")
    fun userEntries(): LiveData<MutableList<UserEntry>>

    @Insert
    suspend fun saveUserEntry(userEntry: UserEntry)
}