package lostankit7.droid.moodtracker.data_layer.repository

import androidx.lifecycle.LiveData
import lostankit7.droid.moodtracker.data_layer.database.dao.TaskCategoryDao
import lostankit7.droid.moodtracker.data_layer.database.entities.TaskCategory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskCategoryRepository @Inject constructor(private val dao: TaskCategoryDao) {

    val taskCategories: LiveData<List<TaskCategory>> = dao.getTaskCategories()

    suspend fun insertTaskCategories(list: List<TaskCategory>) = dao.insertTaskCategories(list)

    suspend fun insertTaskCategory(it: TaskCategory) = dao.insertTaskCategory(it)

    suspend fun updateCategory(it: TaskCategory) = dao.updateCategory(it)

    suspend fun deleteTaskCategory(it: TaskCategory) = dao.deleteTaskCategory(it)
}