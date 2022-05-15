package lostankit7.android.entry_data.mapper

import lostankit7.android.entry_data.local.entities.LocalUserEntry
import lostankit7.android.entry_domain.entities.UserEntry

object UserEntryMapper {

    val List<LocalUserEntry>.toUserEntry
        get() = map { it.toUserEntry }

    val UserEntry.toLocalUserEntryInsert
        get() = LocalUserEntry(date, time, moodIcon, moodName, taskIcons, taskNames, note)
    val UserEntry.toLocalUserEntryUpdate
        get() = LocalUserEntry(date, time, moodIcon, moodName, taskIcons, taskNames, note)
            .also { it.id = id }
    val LocalUserEntry.toUserEntry
        get() = UserEntry(date, time, moodIcon, moodName, taskIcons, taskNames, note, id)
}