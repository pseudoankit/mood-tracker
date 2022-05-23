package lostankit7.android.entry_domain.repository

import androidx.lifecycle.LiveData
import lostankit7.android.entry_domain.entities.TaskIcon

interface TaskIconRepository {
    fun getTaskIcons(category: String): LiveData<List<TaskIcon>>
    suspend fun insertTask(it: TaskIcon)
    suspend fun insertTaskIcons(list: List<TaskIcon>)
    suspend fun updateTask(it: TaskIcon)
    suspend fun deleteTask(it: TaskIcon)
    suspend fun updateTaskCategory(old: String, new: String)
}