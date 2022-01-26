package lostankit7.droid.moodtracker.helper

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.widget.PopupMenu
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KProperty0

object DialogHelper {

    fun <VB : ViewBinding> showDialog(
        activity: Activity, vb: VB, fullWidth: Boolean = true, block: ((VB, Dialog) -> Unit)? = null
    ): Dialog {
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(vb.root)

        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window?.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog.window?.attributes = lp
        block?.invoke(vb, dialog)

        return dialog
    }

    fun showMenu(context: Context, view: View, menu: Int, onClick: (MenuItem) -> Boolean) {
        PopupMenu(context, view).apply {
            setOnMenuItemClickListener {
                onClick(it)
            }
            inflate(menu)
            show()
        }
    }
}