package lostankit7.droid.moodtracker.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import lostankit7.droid.moodtracker.data.database.entities.Icon

@Dao
interface MoodIconDao {

    @Query("SELECT * FROM mood_icon_table")
    fun getMoodIcons() : LiveData<List<Icon>>

    @Insert
    fun insertMoodIcon(icon: Icon)

}