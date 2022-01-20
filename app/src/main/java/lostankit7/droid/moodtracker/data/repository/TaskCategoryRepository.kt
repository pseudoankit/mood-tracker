package lostankit7.droid.moodtracker.data.repository

import androidx.lifecycle.LiveData
import lostankit7.droid.moodtracker.data.database.dao.TaskCategoryDao
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import javax.inject.Inject

class TaskCategoryRepository @Inject constructor(private val dao: TaskCategoryDao) {

    val taskCategories: LiveData<List<TaskCategory>> = dao.getTaskCategories()

    suspend fun insertTaskCategories(list: List<TaskCategory>) = dao.insertTaskCategories(list)

    suspend fun insertTaskCategory(it: TaskCategory) = dao.insertTaskCategory(it)

    suspend fun deleteTaskCategory(it: TaskCategory) = dao.deleteTaskCategory(it)
}