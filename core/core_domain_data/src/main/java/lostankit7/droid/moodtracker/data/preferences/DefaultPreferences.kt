package lostankit7.droid.moodtracker.data.preferences

import android.content.SharedPreferences
import lostankit7.droid.moodtracker.domain.preferences.Preferences
import lostankit7.droid.moodtracker.utils.SharedPrefs.set
import lostankit7.droid.moodtracker.utils.SharedPrefs.get

class DefaultPreferences(
    private val prefs: SharedPreferences,
) : Preferences {

    override fun isInitialLaunch(value: Boolean) {
        prefs[Preferences.IS_INITIAL_LAUNCH] = value
    }

    override fun isInitialLaunch(): Boolean {
        return prefs[Preferences.IS_INITIAL_LAUNCH, true]
    }

}