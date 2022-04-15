package lostankit7.droid.moodtracker.data.database.entities

import android.os.Parcelable

sealed class Icon {
    open var id: Int = 0
    open var name: String = ""
    open var icon: String = ""
    open var isSolid: Boolean = true
}




