package lostankit7.droid.moodtracker.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon

@Dao
interface TaskIconDao {

    @Query("SELECT * FROM TaskIcon where category = :category")
    fun getTaskIcons(category: String): LiveData<List<TaskIcon>>

    @Insert
    suspend fun insertTaskIcons(list: List<TaskIcon>)

    @Insert
    suspend fun insertTaskIcon(icon: TaskIcon)

    @Delete
    suspend fun deleteTask(icon: TaskIcon)

    @Update
    suspend fun updateTask(icon: TaskIcon)

    @Query("UPDATE or REPLACE TaskIcon SET name = :newT WHERE name = :old")
    suspend fun updateTaskCategory(old: String, newT: String)
}