package lostankit7.droid.moodtracker.data_layer.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import lostankit7.droid.moodtracker.data_layer.database.entities.SuggestedTaskName

@Dao
interface SuggestedTaskNameDao {

    @Query("SELECT * FROM SuggestedTaskName")
    fun getSuggestions() : LiveData<List<SuggestedTaskName>>

    @Insert
    suspend fun insertSuggestions(list: List<SuggestedTaskName>)

    @Insert
    suspend fun insertSuggestion(it: SuggestedTaskName)

    @Delete
    suspend fun deleteSuggestion(it: SuggestedTaskName)

}