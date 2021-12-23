package lostankit7.droid.moodtracker.helper

import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

const val dateSeparator = "/"
const val dateFormat = "dd/MM/yyy"
const val timeSeparator = ":"
const val timeFormat = "KK:mm a"
const val AM = "AM"
const val PM = "PM"

fun formatTime(h: Int, m: Int, ap: String): String {
    val hour = when {
        h == 0 -> {
            "12"
        }
        h < 10 -> {
            "0$h"
        }
        else -> {
            h.toString()
        }
    }
    val minute = if (m < 10) {
        "0$m"
    } else {
        m.toString()
    }
    return "$hour$timeSeparator$minute $ap"
}

fun timeToTwelveHour(hourOfDay: Int): Int {
    return when {
        hourOfDay > 12 -> hourOfDay - 12
        hourOfDay == 0 || hourOfDay == 12 -> 12
        else -> hourOfDay
    }
}

fun formatDate(date: Int, month: Int, year: Int): String {
    val dateS = if (date < 10) {
        "0$date"
    } else {
        date.toString()
    }
    val monthS = if (month < 10) {
        "0$month"
    } else {
        month.toString()
    }
    return "$dateS$dateSeparator$monthS$dateSeparator$year"
}

fun getCurrentTime(): String {
    val time = SimpleDateFormat(timeFormat, Locale.getDefault()).format(Date())
    if (time.substring(0, 2) == "00")
        return "12" + time.substring(2)
    return time
}

fun getCurrentDate(): String {
    return SimpleDateFormat(dateFormat, Locale.getDefault()).format(Date())
}