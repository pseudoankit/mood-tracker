package lostankit7.droid.moodtracker.data.repository

import androidx.lifecycle.LiveData
import lostankit7.droid.moodtracker.data.database.dao.TaskCategoryDao
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskCategoryDao: TaskCategoryDao
) {

    val taskCategories: LiveData<List<TaskCategory>> = taskCategoryDao.getTaskCategories()

    suspend fun insertTaskCategories(list: List<TaskCategory>) = taskCategoryDao.insertTaskCategories(list)

    fun deleteTaskCategory(it: TaskCategory) = taskCategoryDao.deleteTaskCategory(it)

    suspend fun insertTaskCategory(it: TaskCategory) = taskCategoryDao.insertTaskCategory(it)

}