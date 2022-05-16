package lostankit7.android.entry_data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import lostankit7.android.entry_data.local.entities.LocalSuggestedMoodIcon

@Dao
interface SuggestedMoodIconDao {

    @Insert
    suspend fun insertSuggestions(icons: List<LocalSuggestedMoodIcon>)

    @Query("SELECT * FROM LocalSuggestedMoodIcon")
    fun suggestedMoodIcons(): LiveData<List<LocalSuggestedMoodIcon>>
}