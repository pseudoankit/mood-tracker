package lostankit7.android.entry_domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoodEntry(val moodIcon: MoodIcon, val date: String, val time: String) : Parcelable
