package lostankit7.droid.moodtracker.ui.entry.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import lostankit7.droid.moodtracker.base.BaseViewModel
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import lostankit7.droid.moodtracker.data.repository.TaskRepository
import lostankit7.droid.moodtracker.data.repository.UserEntriesRepository
import lostankit7.droid.moodtracker.helper.constant.FontAwesomeIcon
import lostankit7.droid.moodtracker.helper.constant.MoodNames
import lostankit7.droid.moodtracker.helper.constant.dbEntrySeparator
import lostankit7.droid.moodtracker.model.MoodEntry
import javax.inject.Inject

class TaskEntryViewModel @Inject constructor(
    private val repository: UserEntriesRepository,
    private val taskRepository: TaskRepository
) : BaseViewModel() {

    val taskCategories = taskRepository.taskCategories

    fun addCategory(item: TaskCategory) = launchIo {
        taskRepository.insertTaskCategory(item)
    }

    fun saveEntry(moodEntry: MoodEntry, tasksMap: MutableMap<Int, TaskIcon>, note: String) {
        val userEntry = mapInputToUserEntry(moodEntry, tasksMap, note)

        launchIo {
            repository.saveUserEntry(userEntry)
        }
    }

    fun getTaskIcons(category: String) = taskRepository.getTaskIcons(category)

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