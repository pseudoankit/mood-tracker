package lostankit7.droid.moodtracker.common.utils

import lostankit7.droid.moodtracker.common.databinding.TaskEntryActionBarBinding

fun TaskEntryActionBarBinding.showBackButton() {
    root.show()
    leftIcon1.show()
    leftIcon2.hide()
    title.hide()
    btnSave.hide()
}

fun TaskEntryActionBarBinding.showBackAndSaveButton() {
    root.show()
    leftIcon1.show()
    leftIcon2.hide()
    title.hide()
    btnSave.show()
}