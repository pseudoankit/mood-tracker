package lostankit7.droid.moodtracker.data_layer.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import lostankit7.droid.moodtracker.data_layer.database.entities.SuggestedMoodName

@Dao
interface SuggestedMoodNameDao {

    @Query("SELECT * FROM SuggestedMoodName")
    fun getSuggestions() : LiveData<List<SuggestedMoodName>>

    @Insert
    suspend fun insertSuggestions(list: List<SuggestedMoodName>)

    @Insert
    suspend fun insertSuggestion(it: SuggestedMoodName)

    @Delete
    suspend fun deleteSuggestion(it: SuggestedMoodName)

}