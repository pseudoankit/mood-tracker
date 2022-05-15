package lostankit7.android.entry_domain.entities

sealed class Suggestion {
    abstract val name: String
}

data class SuggestedMoodName(override val name: String) : Suggestion()

data class SuggestedTaskName(override val name: String) : Suggestion()
