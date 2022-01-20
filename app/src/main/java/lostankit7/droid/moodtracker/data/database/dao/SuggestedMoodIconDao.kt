package lostankit7.droid.moodtracker.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMoodIcon

@Dao
interface SuggestedMoodIconDao {

    @Insert
    suspend fun insertSuggestions(icons: List<SuggestedMoodIcon>)

    @Query("SELECT * FROM SuggestedMoodIcon")
    fun suggestedMoodIcons(): LiveData<List<SuggestedMoodIcon>>
}