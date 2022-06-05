package lostankit7.droid.moodtracker.core.presentation.utils

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import lostankit7.droid.moodtracker.core.utils.Constants.AM
import lostankit7.droid.moodtracker.core.utils.Constants.DATE_FORMAT
import lostankit7.droid.moodtracker.core.utils.Constants.DATE_SEPARATOR
import lostankit7.droid.moodtracker.core.utils.Constants.PM
import lostankit7.droid.moodtracker.core.utils.Constants.TIME_FORMAT
import lostankit7.droid.moodtracker.core.utils.Constants.TIME_SEPARATOR
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {
    private val dayNames =
        arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

    val String.convertToDate
        get() = run {
            try {
                SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH).parse(this)
            } catch (e: ParseException) {
                null
            }
        }

    val String.convertToTime
        get() = run {
            try {
                SimpleDateFormat(TIME_FORMAT, Locale.ENGLISH).parse(this)
            } catch (e: ParseException) {
                null
            }
        }

    /**
     * returns corresponding day of any date ,
     * default formatter = "dd/MM/yyyy"
     * */
    val String.getDay: String
        get() = run {
            val calendar = Calendar.getInstance()
            val parseDate = this.convertToDate ?: return ""
            calendar.time = parseDate

            val day = calendar.get(Calendar.DAY_OF_WEEK)
            day.dayName
        }

    /**
     * function to convert int format of day to actual day
     * @throws[IllegalArgumentException] if input not in range 1..7
     * */
    val Int.dayName
        get() = run {
            val dayIndex = this - 1
            dayNames.getOrElse(dayIndex) { throw IllegalArgumentException("Day should be in 1..7") }
        }

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
        return "$hour$TIME_SEPARATOR$minute $ap"
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
        return "$dateS$DATE_SEPARATOR$monthS$DATE_SEPARATOR$year"
    }

    fun getCurrentTime(): String {
        val time = SimpleDateFormat(TIME_FORMAT, Locale.getDefault()).format(Date())
        if (time.substring(0, 2) == "00")
            return "12" + time.substring(2)
        return time
    }

    fun getCurrentDate(): String {
        return SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(Date())
    }

    fun Context.getSelectedDate(date: String, listener: (date: String) -> Unit) {
        val dateArr = date.split(DATE_SEPARATOR)
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
        val timeArr = time.substring(0, time.length - 3).split(TIME_SEPARATOR)
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
}