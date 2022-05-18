package lostankit7.droid.moodtracker.core.domain.preferences

interface Preferences {
    fun isInitialLaunch(value: Boolean)
    fun isInitialLaunch() : Boolean

    companion object {
        const val IS_INITIAL_LAUNCH = "is_initial_launch"
        const val PREFS_NAME = "mood_tracker_prefs"
    }
}