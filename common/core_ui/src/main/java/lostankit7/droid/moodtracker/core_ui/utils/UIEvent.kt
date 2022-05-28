package lostankit7.droid.moodtracker.core_ui.utils

sealed class UIEvent {
    data class Keyboard(val open: Boolean) : UIEvent()
}
