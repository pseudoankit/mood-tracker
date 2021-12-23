package lostankit7.droid.moodtracker.helper

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import java.util.*

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
    if (cHour!=12 && time.substring(time.length - 2) == PM) cHour += 12
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