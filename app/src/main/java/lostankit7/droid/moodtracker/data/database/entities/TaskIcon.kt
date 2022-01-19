package lostankit7.droid.moodtracker.data.database.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import lostankit7.droid.moodtracker.data.database.AppDatabase

@Entity
data class TaskIcon(val icon: String, val name: String, val category: String) : Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @Ignore
    var isSelected: Boolean = false

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
        id = parcel.readInt()
        isSelected = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(icon)
        parcel.writeString(name)
        parcel.writeString(category)
        parcel.writeInt(id)
        parcel.writeByte(if (isSelected) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TaskIcon> {
        override fun createFromParcel(parcel: Parcel): TaskIcon {
            return TaskIcon(parcel)
        }

        override fun newArray(size: Int): Array<TaskIcon?> {
            return arrayOfNulls(size)
        }
    }

}
