package lostankit7.droid.moodtracker.core.data.preferences

import android.content.SharedPreferences
import lostankit7.droid.moodtracker.core.data.utils.SharedPrefs.get
import lostankit7.droid.moodtracker.core.data.utils.SharedPrefs.set
import lostankit7.droid.moodtracker.core.domain.preferences.Preferences

class DefaultPreferences(
    private val prefs: SharedPreferences,
) : Preferences {

    override var isInitialLaunch: Boolean = false
        get() = prefs[Preferences.IS_INITIAL_LAUNCH, true]
        set(value) {
            prefs[Preferences.IS_INITIAL_LAUNCH] = value
            field = value
        }

    override var profileName: String = ""
        get() = prefs[Preferences.USER_NAME, ""]
        set(value) {
            prefs[Preferences.USER_NAME] = value
            field = value
        }

}