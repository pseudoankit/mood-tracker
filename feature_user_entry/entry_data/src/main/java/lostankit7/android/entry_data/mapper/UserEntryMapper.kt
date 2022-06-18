package lostankit7.android.entry_data.mapper

import lostankit7.android.entry_data.local.entities.LocalUserEntry
import lostankit7.android.entry_domain.entities.UserEntry
import lostankit7.droid.moodtracker.core.domain.entities.shared.Icon
import lostankit7.droid.moodtracker.core.utils.Constants.DB_ENTRY_SEPARATOR

object UserEntryMapper {

    val List<LocalUserEntry>.toUserEntry
        get() = map { it.toEntry }

    val UserEntry.Entry.toLocalUserEntryInsert: LocalUserEntry
        get() {
            val tIcons = StringBuilder("")
            val tNames = StringBuffer("")

            for (icon in taskIcons) {
                tIcons.append("$DB_ENTRY_SEPARATOR${icon.icon}")
                tNames.append("$DB_ENTRY_SEPARATOR${icon.name}")
            }
            if (tIcons.isEmpty()) tIcons.append(DB_ENTRY_SEPARATOR)
            if (tNames.isEmpty()) tNames.append(DB_ENTRY_SEPARATOR)

            return LocalUserEntry(
                date, time, moodIcon, moodName, tIcons.substring(1), tNames.substring(1), notes
            )
        }
    val UserEntry.Entry.toLocalUserEntryUpdate
        get() = toLocalUserEntryInsert.also { it.id = id }
    val LocalUserEntry.toEntry: UserEntry.Entry
        get() {
            val taskIcons = mutableListOf<Icon>()

            val icons = this.taskIcons.split(DB_ENTRY_SEPARATOR)
            val names = taskNames.split(DB_ENTRY_SEPARATOR)

            icons.forEachIndexed { i, _ ->
                taskIcons.add(Icon(icon = icons[i], name = names[i]))
            }

            return UserEntry.Entry(date, time, moodIcon, moodName, taskIcons, note, id)
        }
}