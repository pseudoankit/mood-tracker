package lostankit7.droid.moodtracker.data_layer.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntry(
    var date : String,
    var time: String,
    var moodIcon : String,
    var moodName: String,
    var taskIcons : String,
    var taskNames: String,
    var note: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

