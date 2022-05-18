package lostankit7.android.entry_data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class LocalSuggestion {
    abstract val name: String
}

@Entity
data class LocalSuggestedMoodName(@PrimaryKey override val name: String) : LocalSuggestion()

@Entity
data class LocalSuggestedTaskName(@PrimaryKey override val name: String) : LocalSuggestion()
