package lostankit7.droid.moodtracker.ui.splash

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import lostankit7.droid.moodtracker.data.storage.SharedPrefs
import lostankit7.droid.moodtracker.data.storage.SharedPrefs.get
import lostankit7.droid.moodtracker.data.storage.SharedPrefs.set
import lostankit7.droid.moodtracker.helper.constant.IS_INITIAL_LAUNCH
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val prefs: SharedPreferences
) : ViewModel() {

    fun saveMoodIcons() {
        if (!prefs[IS_INITIAL_LAUNCH, true]) return



        prefs[IS_INITIAL_LAUNCH] = false
    }

}