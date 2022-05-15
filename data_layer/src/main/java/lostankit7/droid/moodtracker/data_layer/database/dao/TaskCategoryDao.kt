package lostankit7.droid.moodtracker.data_layer.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import lostankit7.droid.moodtracker.data_layer.database.entities.TaskCategory

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

    @Update
    suspend fun updateCategory(it: TaskCategory)

}