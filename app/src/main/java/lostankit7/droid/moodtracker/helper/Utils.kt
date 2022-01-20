package lostankit7.droid.moodtracker.helper

import android.app.Activity
import android.content.Context
import android.util.TypedValue
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import lostankit7.droid.moodtracker.R

fun Activity.hideKeyBoard() {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
        ?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
}

fun Activity.showSnackBar(message: String, snackBarColor: Int = R.color.snackBar_error) {
    val snackBar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
    snackBar.view.setBackgroundColor(ContextCompat.getColor(this, snackBarColor))
    snackBar.show()
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun TextView.asTextDimen(id: Int) {
    setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(id))
}