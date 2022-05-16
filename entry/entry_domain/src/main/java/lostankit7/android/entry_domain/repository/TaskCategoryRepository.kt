package lostankit7.android.entry_domain.repository

import androidx.lifecycle.LiveData
import lostankit7.android.entry_domain.entities.TaskCategory

interface TaskCategoryRepository {
    val taskCategories: LiveData<List<TaskCategory>>
    suspend fun insertTaskCategories(list: List<TaskCategory>)
    suspend fun insertTaskCategory(it: TaskCategory)
    suspend fun updateCategory(it: TaskCategory)
    suspend fun deleteTaskCategory(it: TaskCategory)
}