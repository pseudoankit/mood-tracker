package lostankit7.droid.moodtracker.helper

import android.app.Activity
import android.app.Dialog
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.viewbinding.ViewBinding

object Dialog {

    fun <VB : ViewBinding> build(
        activity: Activity, vb: VB, block: (VB, dialog: Dialog) -> Unit
    ): Dialog {
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(vb.root)

        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window?.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog.window?.attributes = lp
        block(vb,dialog)

        return dialog
    }

}