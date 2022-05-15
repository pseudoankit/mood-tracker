package lostankit7.android.entry_domain.entities

sealed class Icon {
    open var id: Int = 0
    open var name: String = ""
    open var icon: String = ""
    open var isSolid: Boolean = true
}




