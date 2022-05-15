package lostankit7.android.entry_data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import lostankit7.android.entry_data.local.dao.TaskCategoryDao
import lostankit7.android.entry_data.mapper.TaskCategoryMapper.toLocalTaskCategoryInsert
import lostankit7.android.entry_data.mapper.TaskCategoryMapper.toLocalTaskCategoryUpdate
import lostankit7.android.entry_data.mapper.TaskCategoryMapper.toTaskCategory
import lostankit7.android.entry_domain.entities.TaskCategory
import lostankit7.android.entry_domain.repository.TaskCategoryRepository

class TaskCategoryRepositoryImpl(private val dao: TaskCategoryDao) : TaskCategoryRepository {

    override val taskCategories: Flow<List<TaskCategory>> =
        dao.getTaskCategories().map { it.toTaskCategory }

    override suspend fun insertTaskCategories(list: List<TaskCategory>) =
        dao.insertTaskCategories(list.toLocalTaskCategoryInsert)

    override suspend fun insertTaskCategory(it: TaskCategory) =
        dao.insertTaskCategory(it.toLocalTaskCategoryInsert)

    override suspend fun updateCategory(it: TaskCategory) =
        dao.updateCategory(it.toLocalTaskCategoryUpdate)

    override suspend fun deleteTaskCategory(it: TaskCategory) =
        dao.deleteTaskCategory(it.toLocalTaskCategoryUpdate)
}