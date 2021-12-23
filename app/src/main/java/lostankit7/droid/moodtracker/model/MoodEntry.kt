package lostankit7.droid.moodtracker.model

import android.os.Parcel
import android.os.Parcelable

data class MoodEntry(val moodIcon: Icon, val date: String, val time: String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Icon::class.java.classLoader)!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(moodIcon, flags)
        parcel.writeString(date)
        parcel.writeString(time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MoodEntry> {
        override fun createFromParcel(parcel: Parcel): MoodEntry {
            return MoodEntry(parcel)
        }

        override fun newArray(size: Int): Array<MoodEntry?> {
            return arrayOfNulls(size)
        }
    }

}
