package lostankit7.droid.moodtracker.data_layer.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import lostankit7.droid.moodtracker.data_layer.database.entities.SuggestedTaskIcon

@Dao
interface SuggestedTaskIconDao {

    @Insert
    suspend fun insertSuggestedIcons(icons: List<SuggestedTaskIcon>)

    @Query("SELECT * FROM SuggestedTaskIcon")
    fun suggestedTaskIcons(): LiveData<List<SuggestedTaskIcon>>
}