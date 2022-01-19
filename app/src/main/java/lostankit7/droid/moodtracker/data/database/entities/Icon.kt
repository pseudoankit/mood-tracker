package lostankit7.droid.moodtracker.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class Icon() {
    abstract val icon: String
    abstract val id: Int
}

@Entity
data class SuggestedMoodIcon(override val icon: String) : Icon() {
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0
}

@Entity
data class SuggestedTaskIcon(override val icon: String) : Icon() {
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0
}




