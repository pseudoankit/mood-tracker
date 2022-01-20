package lostankit7.droid.moodtracker.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SuggestedTaskIcon(
    override var icon: String, override var name: String = "",
    override var isSolid: Boolean = true
) : Icon() {
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0
}