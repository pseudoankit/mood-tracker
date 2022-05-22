package lostankit7.android.entry_data.repository

import androidx.lifecycle.map
import lostankit7.android.entry_data.local.dao.TaskIconDao
import lostankit7.android.entry_data.mapper.TaskIconMapper.toLocalTaskIconInsert
import lostankit7.android.entry_data.mapper.TaskIconMapper.toLocalTaskIconUpdate
import lostankit7.android.entry_data.mapper.TaskIconMapper.toTaskIcon
import lostankit7.android.entry_domain.entities.TaskIcon
import lostankit7.android.entry_domain.repository.TaskIconRepository

class TaskIconRepositoryImpl(private val dao: TaskIconDao) : TaskIconRepository {

    override fun getTaskIcons(category: String) = dao.getTaskIcons(category).map { it.toTaskIcon }

    override suspend fun insertTask(it: TaskIcon) = dao.insertTaskIcon(it.toLocalTaskIconInsert)

    override suspend fun insertTaskIcons(list: List<TaskIcon>) =
        dao.insertTaskIcons(list.toLocalTaskIconInsert)

    override suspend fun updateTask(it: TaskIcon) = dao.updateTask(it.toLocalTaskIconUpdate)

    override suspend fun deleteTask(it: TaskIcon) = dao.deleteTask(it.toLocalTaskIconUpdate)

    override suspend fun updateTaskCategory(old: String, new: String) =
        dao.updateTaskCategory(old, new)
}