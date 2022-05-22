package lostankit7.android.entry_data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import lostankit7.android.entry_data.local.entities.LocalTaskCategory

@Dao
interface TaskCategoryDao {

    @Query("SELECT * FROM LocalTaskCategory")
    fun getTaskCategories() : LiveData<List<LocalTaskCategory>>

    @Insert
    suspend fun insertTaskCategories(list: List<LocalTaskCategory>)

    @Delete
    suspend fun deleteTaskCategory(it: LocalTaskCategory)

    @Insert
    suspend fun insertTaskCategory(it: LocalTaskCategory)

    @Update
    suspend fun updateCategory(it: LocalTaskCategory)

}