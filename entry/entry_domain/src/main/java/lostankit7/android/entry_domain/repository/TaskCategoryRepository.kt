package lostankit7.android.entry_domain.repository

import kotlinx.coroutines.flow.Flow
import lostankit7.android.entry_domain.entities.TaskCategory

interface TaskCategoryRepository {
    val taskCategories: Flow<List<TaskCategory>>
    suspend fun insertTaskCategories(list: List<TaskCategory>)
    suspend fun insertTaskCategory(it: TaskCategory)
    suspend fun updateCategory(it: TaskCategory)
    suspend fun deleteTaskCategory(it: TaskCategory)
}