package lostankit7.droid.moodtracker.core_presentation.utils.entity

sealed class UiEvent<T> {
    class Success<T> : UiEvent<T>()
    object Loading : UiEvent<Nothing>()
    data class Error(val message: String) : UiEvent<Nothing>()
}