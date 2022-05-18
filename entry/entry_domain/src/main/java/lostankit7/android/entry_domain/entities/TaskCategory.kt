package lostankit7.android.entry_domain.entities

data class TaskCategory(
    override var name: String,
    override var id: Int = 0,
    var isExpanded: Boolean = false,
) : Icon()