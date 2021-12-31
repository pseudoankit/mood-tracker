package lostankit7.droid.moodtracker.data.database.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import lostankit7.droid.moodtracker.data.database.AppDatabase

@Entity
data class TaskIcon(val icon: String, val name: String, val category: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @Ignore
    var isSelected: Boolean = false

}
