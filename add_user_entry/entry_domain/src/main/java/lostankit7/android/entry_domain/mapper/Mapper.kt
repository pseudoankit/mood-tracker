package lostankit7.android.entry_domain.mapper

import lostankit7.android.entry_domain.entities.MoodEntry
import lostankit7.android.entry_domain.entities.TaskIcon
import lostankit7.droid.moodtracker.core.domain.entities.shared.Icon
import lostankit7.droid.moodtracker.core.domain.entities.shared.UserEntry

object Mapper {
    fun mapDataToUserEntry(
        moodEntry: MoodEntry,
        tasksMap: MutableMap<Int, TaskIcon>,
        note: String,
    ): UserEntry {
        val taskIcons = mutableListOf<Icon>()

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

    val TaskIcon.toIcon: Icon get() = Icon(name, icon)
}