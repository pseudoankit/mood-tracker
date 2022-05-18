package lostankit7.android.entry_domain.entities

import kotlinx.parcelize.Parcelize

data class SuggestedMoodIcon(
    override var icon: String,
    override var isSolid: Boolean = false,
    override var id: Int = 0,
) : Icon()