package lostankit7.android.entry_domain.entities

data class UserEntry(
    var date : String,
    var time: String,
    var moodIcon : String,
    var moodName: String,
    var taskIcons : String,
    var taskNames: String,
    var note: String,
    var id: Int = 0
)