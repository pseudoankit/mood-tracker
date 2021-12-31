package lostankit7.droid.moodtracker.ui.splash

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import lostankit7.droid.moodtracker.data.repository.SharedPrefsRepository
import lostankit7.droid.moodtracker.data.repository.SplashRepository
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val prefs: SharedPrefsRepository,
    private val splashRepository: SplashRepository
) : ViewModel() {

    //check for context in view model
    fun saveDefaultIcons(context: Context) {
        if (!prefs.isInitialLaunch()) return

        viewModelScope.launch(Dispatchers.IO) {
            splashRepository.insertMoodIcons(DefaultValues.moodIcons(context))
            splashRepository.insertSuggestedMoods(DefaultValues.suggestedMoodIcons())
            splashRepository.insertTaskCategories(DefaultValues.taskCategories(context))
            splashRepository.insertTaskIcons(DefaultValues.taskIcons(context))
        }
        //todo if insertion fails
        prefs.isInitialLaunch(false)
    }
}