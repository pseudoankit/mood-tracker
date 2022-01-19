package lostankit7.droid.moodtracker.data.repository

import androidx.lifecycle.LiveData
import lostankit7.droid.moodtracker.data.database.dao.TaskCategoryDao
import lostankit7.droid.moodtracker.data.database.dao.TaskIconDao
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskCategoryDao: TaskCategoryDao,
    private val taskIconDao: TaskIconDao
) {

    val taskCategories: LiveData<List<TaskCategory>> = taskCategoryDao.getTaskCategories()
    suspend fun insertTaskCategories(list: List<TaskCategory>) =
        taskCategoryDao.insertTaskCategories(list)

    suspend fun insertTaskCategory(it: TaskCategory) = taskCategoryDao.insertTaskCategory(it)
    suspend fun deleteTaskCategory(it: TaskCategory) = taskCategoryDao.deleteTaskCategory(it)

    fun getTaskIcons(category: String) = taskIconDao.getTaskIcons(category)
    suspend fun insertTask(it: TaskIcon) = taskIconDao.insertTaskIcon(it)
    suspend fun updateTask(it: TaskIcon) = taskIconDao.updateTask(it)
    suspend fun deleteTask(it: TaskIcon) = taskIconDao.deleteTask(it)
}