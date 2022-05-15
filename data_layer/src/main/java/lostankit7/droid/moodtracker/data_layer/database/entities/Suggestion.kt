package lostankit7.droid.moodtracker.data_layer.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class Suggestion {
    abstract val name: String
}

@Entity
data class SuggestedMoodName(@PrimaryKey override val name: String) : Suggestion()

@Entity
data class SuggestedTaskName(@PrimaryKey override val name: String) : Suggestion()
