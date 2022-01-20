package lostankit7.droid.moodtracker.ui.entry.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import lostankit7.droid.moodtracker.base.BaseViewModel
import lostankit7.droid.moodtracker.data.database.dao.TaskIconDao
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import lostankit7.droid.moodtracker.data.repository.*
import lostankit7.droid.moodtracker.helper.constant.FontAwesomeIcon
import lostankit7.droid.moodtracker.helper.constant.MoodNames
import lostankit7.droid.moodtracker.helper.constant.dbEntrySeparator
import lostankit7.droid.moodtracker.model.MoodEntry
import javax.inject.Inject

class TaskEntryViewModel @Inject constructor(
    private val repository: UserEntriesRepository,
    private val taskCategoryRepo: TaskCategoryRepository,
    private val taskIconRepo: TaskIconRepository,
    suggestedTaskRepo: SuggestedTaskIconRepository
) : BaseViewModel() {

    val suggestedTaskIcons = suggestedTaskRepo.suggestedTaskIcon

    val taskCategories = taskCategoryRepo.taskCategories
    fun addCategory(item: TaskCategory) = launchIo { taskCategoryRepo.insertTaskCategory(item) }

    fun getTaskIcons(category: String) = taskIconRepo.getTaskIcons(category)
    fun insertTask(it: TaskIcon) = launchIo { taskIconRepo.insertTask(it) }
    fun updateTask(it: TaskIcon) = launchIo { taskIconRepo.updateTask(it) }
    fun deleteTask(it: TaskIcon) = launchIo { taskIconRepo.deleteTask(it) }

    fun saveEntry(moodEntry: MoodEntry, tasksMap: MutableMap<Int, TaskIcon>, note: String) =
        launchIo {
            repository.saveUserEntry(mapInputToUserEntry(moodEntry, tasksMap, note))
        }

    private fun mapInputToUserEntry(
        moodEntry: MoodEntry,
        tasksMap: MutableMap<Int, TaskIcon>,
        note: String
    ): UserEntry {
        val taskIcons = StringBuilder("")
        val taskNames = StringBuffer("")

        for ((_, icon) in tasksMap) {
            taskIcons.append("${dbEntrySeparator}${icon.icon}")
            taskNames.append("${dbEntrySeparator}${icon.name}")
        }
        if (taskIcons.isEmpty()) taskIcons.append(dbEntrySeparator)
        if (taskNames.isEmpty()) taskNames.append(dbEntrySeparator)

        return UserEntry(
            moodEntry.date,
            moodEntry.time,
            moodEntry.moodIcon.icon,
            moodEntry.moodIcon.name,
            taskIcons.substring(1),
            taskNames.substring(1),
            note
        )
    }

}