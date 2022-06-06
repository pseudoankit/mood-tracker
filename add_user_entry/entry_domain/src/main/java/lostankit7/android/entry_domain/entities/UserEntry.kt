package lostankit7.android.entry_domain.entities

import lostankit7.droid.moodtracker.core.domain.entities.shared.Icon
import lostankit7.droid.moodtracker.core.presentation.utils.DateTimeUtils.convertToDate
import lostankit7.droid.moodtracker.core.presentation.utils.DateTimeUtils.convertToTime

sealed class UserEntry {

    data class Date(val date: String) : UserEntry()

    data class Entry(
        val date: String,
        val time: String,
        val moodIcon: String,
        val moodName: String,
        val taskIcons: List<Icon>,
        val notes: String,
        val id: Int = 0,
    ) : UserEntry() {
        companion object {
            val List<Entry>.sort
                get() = run {
                    sortedWith { o1, o2 ->
                        val date1 = o1.date.convertToDate
                        val date2 = o2.date.convertToDate
                        val time1 = o1.time.convertToTime
                        val time2 = o2.time.convertToTime

                        return@sortedWith if (date1 != date2) date1?.compareTo(date2) ?: 0
                        else time1?.compareTo(time2) ?: 0
                    }
                }
        }
    }

    companion object {
        val List<Entry>.addDateHeaders: List<UserEntry>
            get() = run {
                val newList = mutableListOf<UserEntry>()
                this.forEachIndexed { index, entry ->
                    val date = entry.date
                    val prevDate = this.getOrNull(index - 1)?.date
                    val shouldInsertDate = prevDate == null || date != prevDate
                    if (shouldInsertDate)
                        newList.add(Date(date = date))
                    newList.add(entry)
                }
                newList
            }
    }
}