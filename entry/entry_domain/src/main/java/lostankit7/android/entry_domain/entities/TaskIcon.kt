package lostankit7.android.entry_domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import lostankit7.droid.moodtracker.core.domain.entities.BaseIcon

@Parcelize
data class TaskIcon(
    override var icon: String,
    override var name: String,
    val category: String,
    override var isSolid: Boolean = true,
    override var id: Int = 0,
    var isSelected: Boolean = false,
) : BaseIcon(), Parcelable