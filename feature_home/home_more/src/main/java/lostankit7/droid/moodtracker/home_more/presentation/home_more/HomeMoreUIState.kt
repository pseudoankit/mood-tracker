package lostankit7.droid.moodtracker.home_more.presentation.home_more

import lostankit7.droid.moodtracker.home_more.R

data class HomeMoreUIState(
    val profilePic: Int = R.drawable.ic_me,
    val profileName: String = "",
    val profileEditEnabled: Boolean = false,
)