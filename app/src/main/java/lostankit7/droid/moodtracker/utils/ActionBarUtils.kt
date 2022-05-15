package lostankit7.droid.moodtracker.utils

import lostankit7.droid.moodtracker.core_presentation.databinding.CommonActionBarBinding
import lostankit7.droid.moodtracker.core_presentation.utils.hide
import lostankit7.droid.moodtracker.core_presentation.utils.show

fun CommonActionBarBinding.showBackButton() {
    root.show()
    leftIcon1.show()
    leftIcon2.hide()
    title.hide()
    btnSave.hide()
}

fun CommonActionBarBinding.showBackAndSaveButton() {
    root.show()
    leftIcon1.show()
    leftIcon2.hide()
    title.hide()
    btnSave.show()
}