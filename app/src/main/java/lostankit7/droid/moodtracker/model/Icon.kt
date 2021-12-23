package lostankit7.droid.moodtracker.model

import android.os.Parcel
import android.os.Parcelable

data class Icon(val icon: String, val name: String) : Parcelable {
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

    companion object CREATOR : Parcelable.Creator<Icon> {
        override fun createFromParcel(parcel: Parcel): Icon {
            return Icon(parcel)
        }

        override fun newArray(size: Int): Array<Icon?> {
            return arrayOfNulls(size)
        }
    }
}
