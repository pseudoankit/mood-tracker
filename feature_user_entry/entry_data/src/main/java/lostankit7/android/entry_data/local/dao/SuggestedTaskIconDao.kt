package lostankit7.android.entry_data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import lostankit7.android.entry_data.local.entities.LocalSuggestedTaskIcon

@Dao
interface SuggestedTaskIconDao {

    @Insert
    suspend fun insertSuggestedIcons(icons: List<LocalSuggestedTaskIcon>)

    @Query("SELECT * FROM LocalSuggestedTaskIcon")
    fun suggestedTaskIcons(): LiveData<List<LocalSuggestedTaskIcon>>
}