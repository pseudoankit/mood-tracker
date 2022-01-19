package lostankit7.droid.moodtracker.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory

@Dao
interface TaskCategoryDao {

    @Query("SELECT * FROM TaskCategory")
    fun getTaskCategories() : LiveData<List<TaskCategory>>

    @Insert
    suspend fun insertTaskCategories(list: List<TaskCategory>)

    @Delete
    suspend fun deleteTaskCategory(it: TaskCategory)

    @Insert
    suspend fun insertTaskCategory(it: TaskCategory)

}