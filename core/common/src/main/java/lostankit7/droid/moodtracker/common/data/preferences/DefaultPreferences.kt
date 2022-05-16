package lostankit7.droid.moodtracker.common.data.preferences

import android.content.SharedPreferences
import lostankit7.droid.moodtracker.common.domain.preferences.Preferences
import lostankit7.droid.moodtracker.common.utils.SharedPrefs.get
import lostankit7.droid.moodtracker.common.utils.SharedPrefs.set

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