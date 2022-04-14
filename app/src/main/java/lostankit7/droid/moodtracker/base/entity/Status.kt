package lostankit7.droid.moodtracker.base.entity

sealed class Status<T> {
    class Success<T> : Status<T>()
    object Loading : Status<Nothing>()
    data class Error(val message: String) : Status<Nothing>()
}