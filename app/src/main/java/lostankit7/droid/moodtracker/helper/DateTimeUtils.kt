package lostankit7.droid.moodtracker.helper

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
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

fun Context.getSelectedDate(date: String, listener: (date: String) -> Unit) {
    val dateArr = date.split(dateSeparator)
    val mDay = dateArr[0].toInt()
    val mMonth = dateArr[1].toInt() - 1
    val mYear = dateArr[2].toInt()

    val mDatePicker = DatePickerDialog(
        this,
        { _, year, month, dayOfMonth ->
            listener.invoke(formatDate(dayOfMonth, (month + 1), year))
        }, mYear, mMonth, mDay
    )
    mDatePicker.datePicker.maxDate = Calendar.getInstance().timeInMillis
    mDatePicker.show()
}

fun Context.getSelectedTime(time: String, listener: (time: String) -> Unit) {
    val timeArr = time.substring(0, time.length - 3).split(timeSeparator)
    var cHour = timeArr[0].toInt()
    if (cHour != 12 && time.substring(time.length - 2) == PM) cHour += 12
    val cMin = timeArr[1].toInt()

    val mTimePicker = TimePickerDialog(
        this,
        { _, hourOfDay, minute ->
            var ap = ""
            val datetime = Calendar.getInstance()
            datetime[Calendar.HOUR_OF_DAY] = hourOfDay
            datetime[Calendar.MINUTE] = minute
            if (datetime[Calendar.AM_PM] == Calendar.AM) ap = AM
            else if (datetime[Calendar.AM_PM] == Calendar.PM) ap = PM

            val hour = timeToTwelveHour(hourOfDay)
            listener.invoke(formatTime(hour, minute, ap))
        }, cHour, cMin, false
    )
    mTimePicker.show()
}