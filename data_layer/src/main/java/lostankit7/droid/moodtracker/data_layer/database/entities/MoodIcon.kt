package lostankit7.droid.moodtracker.data_layer.database.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class MoodIcon(
    override var icon: String, override var name: String,
    override var isSolid: Boolean = false
) : Icon(), Parcelable {

    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0

    @Ignore
    var isSelected: Boolean = false

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    ) {
        isSelected = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(icon)
        parcel.writeString(name)
        parcel.writeByte(if (isSelected) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MoodIcon> {
        override fun createFromParcel(parcel: Parcel): MoodIcon {
            return MoodIcon(parcel)
        }

        override fun newArray(size: Int): Array<MoodIcon?> {
            return arrayOfNulls(size)
        }
    }
}
