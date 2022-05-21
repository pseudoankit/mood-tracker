package lostankit7.android.entry_domain.entities

import lostankit7.droid.moodtracker.core.domain.entities.BaseIcon

data class TaskCategory(
    override var name: String,
    override var id: Int = 0,
    var isExpanded: Boolean = false,
) : BaseIcon()