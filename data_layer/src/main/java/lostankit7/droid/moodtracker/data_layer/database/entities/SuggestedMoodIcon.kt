package lostankit7.droid.moodtracker.data_layer.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SuggestedMoodIcon(override var icon: String, override var isSolid: Boolean = false) :
    Icon() {
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0
}