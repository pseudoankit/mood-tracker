package lostankit7.android.entry_domain.repository

import kotlinx.coroutines.flow.Flow
import lostankit7.android.entry_domain.entities.TaskIcon

interface TaskIconRepository {
    fun getTaskIcons(category: String): Flow<List<TaskIcon>>
}