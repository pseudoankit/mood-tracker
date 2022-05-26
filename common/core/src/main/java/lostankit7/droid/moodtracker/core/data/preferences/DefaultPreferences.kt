package lostankit7.droid.moodtracker.core.data.preferences

import android.content.SharedPreferences
import lostankit7.droid.moodtracker.core.data.utils.SharedPrefs.get
import lostankit7.droid.moodtracker.core.data.utils.SharedPrefs.set
import lostankit7.droid.moodtracker.core.domain.preferences.Preferences

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