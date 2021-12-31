package lostankit7.droid.moodtracker.data.database.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class TaskCategory(
    val category: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @Ignore
    var isExpanded: Boolean = false
}