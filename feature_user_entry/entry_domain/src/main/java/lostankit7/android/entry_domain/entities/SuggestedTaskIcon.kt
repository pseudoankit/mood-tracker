package lostankit7.android.entry_domain.entities

import lostankit7.droid.moodtracker.core.domain.entities.shared.BaseIcon

data class SuggestedTaskIcon(
    override var icon: String, override var name: String = "",
    override var isSolid: Boolean = true,
    override var id: Int = 0
) : BaseIcon()