package lostankit7.droid.moodtracker.ui.main.entry.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import lostankit7.droid.moodtracker.helper.constant.Constants.dbEntrySeparator
import lostankit7.droid.moodtracker.helper.constant.FontAwesomeIcon
import lostankit7.droid.moodtracker.helper.constant.MoodNames
import lostankit7.droid.moodtracker.helper.constant.TaskCategories
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.repository.UserEntriesRepository
import lostankit7.droid.moodtracker.model.MoodEntry
import lostankit7.droid.moodtracker.model.TaskCategory
import javax.inject.Inject

class TaskEntryViewModel @Inject constructor(
    private val repository: UserEntriesRepository
) : ViewModel() {

    fun saveEntry(moodEntry: MoodEntry, tasksMap: MutableMap<Int, MoodIcon>, note: String) {

        val userEntry = getEntry(moodEntry, tasksMap, note)
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveUserEntry(userEntry)
        }
    }

    fun getTaskCategories() = mutableListOf(
        TaskCategory(TaskCategories.other, true),
        TaskCategory(TaskCategories.entertainment, false)
    )

    fun getTaskOfCategory(category: String) = mutableListOf(
        MoodIcon(FontAwesomeIcon.happy, MoodNames.happy),
        MoodIcon(FontAwesomeIcon.jolly, MoodNames.jolly),
        MoodIcon(FontAwesomeIcon.meh, MoodNames.meh),
        MoodIcon(FontAwesomeIcon.sad, MoodNames.sad),
        MoodIcon(FontAwesomeIcon.awful, MoodNames.awful)
    )


    private fun getEntry(
        moodEntry: MoodEntry,
        tasksMap: MutableMap<Int, MoodIcon>,
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