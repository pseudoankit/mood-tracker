package lostankit7.droid.moodtracker.core.domain.preferences

interface Preferences {

    var profileName: String
    var isInitialLaunch: Boolean

    companion object {
        const val USER_NAME = "user_name"
        const val IS_INITIAL_LAUNCH = "is_initial_launch"
        const val PREFS_NAME = "mood_tracker_prefs"
    }
}