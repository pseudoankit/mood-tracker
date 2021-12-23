package lostankit7.droid.moodtracker.helper

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import lostankit7.droid.moodtracker.R

fun Activity.showSnackBar(message: String, snackBarColor: Int = R.color.snackBar_error) {
    val snackBar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
    snackBar.view.setBackgroundColor(ContextCompat.getColor(this, snackBarColor))
    snackBar.show()
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}