package lostankit7.droid.moodtracker.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon

@Dao
interface MoodIconDao {

    @Query("SELECT * FROM MoodIcon")
    fun getMoodIcons() : LiveData<List<MoodIcon>>

    @Insert
    suspend fun insertMoodIcon(icon: MoodIcon)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    suspend fun insertMoodIcons(icons: List<MoodIcon>) : LongArray

}