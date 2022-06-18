package lostankit7.android.entry_data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import lostankit7.android.entry_data.local.entities.LocalSuggestedMoodName

@Dao
interface SuggestedMoodNameDao {

    @Query("SELECT * FROM LocalSuggestedMoodName")
    fun getSuggestions() : LiveData<List<LocalSuggestedMoodName>>

    @Insert
    suspend fun insertSuggestions(list: List<LocalSuggestedMoodName>)

    @Insert
    suspend fun insertSuggestion(it: LocalSuggestedMoodName)

    @Delete
    suspend fun deleteSuggestion(it: LocalSuggestedMoodName)

}