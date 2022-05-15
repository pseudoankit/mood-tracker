package lostankit7.droid.moodtracker.data_layer.database.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class TaskCategory(override var name: String) : Icon() {
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0

    @Ignore
    var isExpanded: Boolean = false
}