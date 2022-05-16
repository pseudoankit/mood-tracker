package lostankit7.android.entry_domain.entities

data class UserEntry(
    var date : String,
    var time: String,
    var moodIcon : String,
    var moodName: String,
    var taskIcons : List<Icon.Icon>,
    var note: String,
    var id: Int = 0
)