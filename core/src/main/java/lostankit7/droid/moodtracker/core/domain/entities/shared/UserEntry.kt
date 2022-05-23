package lostankit7.droid.moodtracker.core.domain.entities.shared

data class UserEntry(
    var date : String,
    var time: String,
    var moodIcon : String,
    var moodName: String,
    var taskIcons : List<Icon>,
    var note: String,
    var id: Int = 0
)