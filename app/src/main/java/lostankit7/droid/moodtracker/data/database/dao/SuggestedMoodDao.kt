package lostankit7.droid.moodtracker.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMood

@Dao
interface SuggestedMoodDao {

    @Insert
    suspend fun insertSuggestions(icons: List<SuggestedMood>)

    @Query("SELECT * FROM SuggestedMood")
    fun suggestedMoodIcons(): LiveData<List<SuggestedMood>>

    @Query("SELECT * FROM SuggestedMood")
    fun suggestedMoodNames(): List<SuggestedMood>

}