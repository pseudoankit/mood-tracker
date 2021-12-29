package lostankit7.droid.moodtracker.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SuggestedMood(val icon: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}