package lostankit7.droid.moodtracker.home_more.presentation.home_more

sealed class HomeMoreEvent {
    data class UpdateProfileName(val name: String) : HomeMoreEvent()
    object AlterProfileEditEnabledState : HomeMoreEvent()
    data class UpdateProfilePic(val pic: Int) : HomeMoreEvent()
}