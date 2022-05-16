package lostankit7.android.entry_domain.mapper

import lostankit7.android.entry_domain.entities.MoodEntry
import lostankit7.android.entry_domain.entities.TaskIcon
import lostankit7.android.entry_domain.entities.UserEntry
import lostankit7.droid.moodtracker.common.utils.Constants

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