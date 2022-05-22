package lostankit7.android.entry_data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import lostankit7.android.entry_data.local.entities.LocalMoodIcon

@Dao
interface MoodIconDao {

    @Query("SELECT * FROM LocalMoodIcon")
    fun getMoodIcons(): LiveData<List<LocalMoodIcon>>

    @Insert
    suspend fun insertMoodIcons(icons: List<LocalMoodIcon>)

    @Insert
    suspend fun insertMoodIcon(icon: LocalMoodIcon)

    @Delete
    suspend fun deleteMoodIcon(icon: LocalMoodIcon)

    @Update
    suspend fun updateMoodIcon(icon: LocalMoodIcon)

}