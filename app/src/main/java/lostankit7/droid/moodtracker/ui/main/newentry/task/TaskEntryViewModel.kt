package lostankit7.droid.moodtracker.ui.main.newentry.task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import lostankit7.droid.moodtracker.data.database.AppDatabase
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import lostankit7.droid.moodtracker.data.repository.AddUserEntryRepository
import lostankit7.droid.moodtracker.helper.Constants.dbEntrySeparator
import lostankit7.droid.moodtracker.helper.FontAwesomeIcon
import lostankit7.droid.moodtracker.helper.MoodNames
import lostankit7.droid.moodtracker.helper.TaskCategories
import lostankit7.droid.moodtracker.model.Icon
import lostankit7.droid.moodtracker.model.MoodEntry
import lostankit7.droid.moodtracker.model.TaskCategory
import javax.inject.Inject

class TaskEntryViewModel @Inject constructor(
    private val repository: AddUserEntryRepository
) : ViewModel() {

    /*private val repository: AddUserEntryRepository

    init {
        val dao = AppDatabase.getDatabase(application,viewModelScope).userEntryDao()
        repository = AddUserEntryRepository(dao)
    }*/


    fun saveEntry(moodEntry: MoodEntry, tasksMap: MutableMap<Int, Icon>, note: String) {

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
        Icon(FontAwesomeIcon.happy, MoodNames.happy),
        Icon(FontAwesomeIcon.jolly, MoodNames.jolly),
        Icon(FontAwesomeIcon.meh, MoodNames.meh),
        Icon(FontAwesomeIcon.sad, MoodNames.sad),
        Icon(FontAwesomeIcon.awful, MoodNames.awful)
    )


    private fun getEntry(
        moodEntry: MoodEntry,
        tasksMap: MutableMap<Int, Icon>,
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