package lostankit7.droid.moodtracker.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon

@Dao
interface TaskIconDao {

    @Query("SELECT * FROM TaskIcon")
    fun getTaskIcons(): LiveData<List<TaskIcon>>

    @Insert
    suspend fun insertTaskIcons(list: List<TaskIcon>)

    @Insert
    suspend fun insertTaskIcon(icon: TaskIcon)

}