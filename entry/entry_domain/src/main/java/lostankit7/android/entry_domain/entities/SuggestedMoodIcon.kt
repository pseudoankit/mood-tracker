package lostankit7.android.entry_domain.entities

import lostankit7.droid.moodtracker.core.domain.entities.shared.BaseIcon

data class SuggestedMoodIcon(
    override var icon: String,
    override var isSolid: Boolean = false,
    override var id: Int = 0,
) : BaseIcon()