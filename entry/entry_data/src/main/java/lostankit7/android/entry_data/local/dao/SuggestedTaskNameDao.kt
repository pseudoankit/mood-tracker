package lostankit7.android.entry_data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import lostankit7.android.entry_data.local.entities.LocalSuggestedTaskName

@Dao
interface SuggestedTaskNameDao {

    @Query("SELECT * FROM LocalSuggestedTaskName")
    fun getSuggestions() : Flow<List<LocalSuggestedTaskName>>

    @Insert
    suspend fun insertSuggestions(list: List<LocalSuggestedTaskName>)

    @Insert
    suspend fun insertSuggestion(it: LocalSuggestedTaskName)

    @Delete
    suspend fun deleteSuggestion(it: LocalSuggestedTaskName)

}