package lostankit7.droid.moodtracker.helper

import android.app.Activity
import android.app.Dialog
import android.view.View

fun Activity.inflateDialog(view: View): Dialog {
    val dialog = Dialog(this)
    dialog.setContentView(view)
    return dialog
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}