package lostankit7.android.entry_data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalUserEntry(
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

