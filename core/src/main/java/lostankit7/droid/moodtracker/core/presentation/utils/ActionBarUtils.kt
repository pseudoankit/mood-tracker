package lostankit7.droid.moodtracker.core.presentation.utils

import lostankit7.droid.moodtracker.core.R
import lostankit7.droid.moodtracker.core.databinding.CommonActionBarBinding
import lostankit7.droid.moodtracker.core_presentation.utils.hide
import lostankit7.droid.moodtracker.core_presentation.utils.show

object ActionBarUtils {

    fun CommonActionBarBinding.applyDefault() {
        leftIcon1.text = root.context.resources.getString(R.string.fas_circular_back)
        btnBack.show()
        leftIcon1.show()
        leftIcon2.hide()
        title.hide()
        btnSave.hide()
    }

    fun CommonActionBarBinding.showBackButtonWithIcon(icon: String) {
        leftIcon2.apply {
            show()
            text = icon
        }
    }

    fun CommonActionBarBinding.showSaveButton() {
        btnSave.show()
    }

    fun CommonActionBarBinding.updateTitle(txt: String) {
        title.apply {
            show()
            text = txt
        }
    }
}