package lostankit7.droid.moodtracker.data_layer.repository

import lostankit7.droid.moodtracker.data_layer.database.dao.TaskIconDao
import lostankit7.droid.moodtracker.data_layer.database.entities.TaskIcon
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskIconRepository @Inject constructor(private val dao: TaskIconDao) {

    fun getTaskIcons(category: String) = dao.getTaskIcons(category)

    suspend fun insertTask(it: TaskIcon) = dao.insertTaskIcon(it)

    suspend fun insertTaskIcons(list: List<TaskIcon>) = dao.insertTaskIcons(list)

    suspend fun updateTask(it: TaskIcon) = dao.updateTask(it)

    suspend fun deleteTask(it: TaskIcon) = dao.deleteTask(it)

    suspend fun updateTaskCategory(old: String, new: String) = dao.updateTaskCategory(old, new)
}