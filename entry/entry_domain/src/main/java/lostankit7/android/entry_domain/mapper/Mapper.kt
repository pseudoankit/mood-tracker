package lostankit7.android.entry_domain.mapper

import lostankit7.android.entry_domain.entities.Icon
import lostankit7.android.entry_domain.entities.MoodEntry
import lostankit7.android.entry_domain.entities.TaskIcon
import lostankit7.android.entry_domain.entities.UserEntry

object Mapper {
    fun mapDataToUserEntry(
        moodEntry: MoodEntry,
        tasksMap: MutableMap<Int, TaskIcon>,
        note: String,
    ): UserEntry {
        val taskIcons = mutableListOf<Icon.Icon>()

        for ((_, taskIcon) in tasksMap) {
            taskIcons.add(taskIcon.toIcon)
        }

        return UserEntry(
            moodEntry.date,
            moodEntry.time,
            moodEntry.moodIcon.icon,
            moodEntry.moodIcon.name,
            taskIcons,
            note
        )
    }

    val TaskIcon.toIcon: Icon.Icon get() = Icon.Icon(name, icon)
}