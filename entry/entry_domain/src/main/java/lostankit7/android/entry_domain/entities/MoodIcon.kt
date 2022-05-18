package lostankit7.android.entry_domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoodIcon(
    override var icon: String, override var name: String,
    override var isSolid: Boolean = false,
    override var id: Int = 0,
    var isSelected: Boolean = false,
) : Icon(), Parcelable
