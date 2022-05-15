package lostankit7.droid.moodtracker.domain

import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import lostankit7.droid.moodtracker.model.MoodEntry
import lostankit7.droid.moodtracker.core_presentation.utils.Constants

object Mapper {
    fun mapDataToUserEntry(
        moodEntry: MoodEntry,
        tasksMap: MutableMap<Int, TaskIcon>,
        note: String,
    ): UserEntry {
        val taskIcons = StringBuilder("")
        val taskNames = StringBuffer("")

        for ((_, icon) in tasksMap) {
            taskIcons.append("${Constants.DB_ENTRY_SEPARATOR}${icon.icon}")
            taskNames.append("${Constants.DB_ENTRY_SEPARATOR}${icon.name}")
        }
        if (taskIcons.isEmpty()) taskIcons.append(Constants.DB_ENTRY_SEPARATOR)
        if (taskNames.isEmpty()) taskNames.append(Constants.DB_ENTRY_SEPARATOR)

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