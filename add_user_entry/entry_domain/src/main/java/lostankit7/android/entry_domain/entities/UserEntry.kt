package lostankit7.android.entry_domain.entities

import lostankit7.droid.moodtracker.core.domain.entities.shared.Icon
import lostankit7.droid.moodtracker.core.presentation.utils.DateTimeUtils.convertToDate
import lostankit7.droid.moodtracker.core.presentation.utils.DateTimeUtils.convertToTime

data class UserEntry(
    var date: String,
    var time: String,
    var moodIcon: String,
    var moodName: String,
    var taskIcons: List<Icon>,
    var notes: String,
    var id: Int = 0,
) {
    companion object {
        val List<UserEntry>.sort
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