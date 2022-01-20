package lostankit7.droid.moodtracker.helper

import android.app.Activity
import android.app.Dialog
import android.view.View

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.invert(show: Boolean) {
    if (show) show() else hide()
}