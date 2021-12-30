package lostankit7.droid.moodtracker.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon

@Dao
interface MoodIconDao {

    @Query("SELECT * FROM MoodIcon")
    fun getMoodIcons(): LiveData<List<MoodIcon>>

    @Insert
    suspend fun insertMoodIcon(icon: MoodIcon)

    @Delete
    fun deleteMoodIcon(icon: MoodIcon)

    @Update
    fun updateMoodIcon(icon: MoodIcon)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    suspend fun insertMoodIcons(icons: List<MoodIcon>): LongArray

}