package lostankit7.android.entry_domain.entities

data class SuggestedTaskIcon(
    override var icon: String, override var name: String = "",
    override var isSolid: Boolean = true,
    override var id: Int = 0
) : Icon()