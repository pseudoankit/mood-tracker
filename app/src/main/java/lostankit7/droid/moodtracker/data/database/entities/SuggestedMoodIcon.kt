package lostankit7.droid.moodtracker.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SuggestedMoodIcon(override var icon: String) : Icon() {
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0
}