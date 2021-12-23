package lostankit7.droid.moodtracker.model

sealed class Status {
    data class Success(val message: String? = "") : Status()
    data class Error(val message: String? = "") : Status()
    data class Loading(val message: String = "Loading..") : Status()
    object Empty : Status()
}