package lostankit7.droid.moodtracker.ui.splash

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

    fun saveDefaultIcons() {
        if (!prefs.isInitialLaunch()) return

        viewModelScope.launch(Dispatchers.IO) {
            splashRepository.insertMoodIcons(DefaultValues.moodIcons())
            splashRepository.insertSuggestedMoods(DefaultValues.suggestedMoodIcons())
            splashRepository.insertTaskCategories(DefaultValues.taskCategories())
        }
        //todo if insertion fails
        prefs.isInitialLaunch(false)
    }
}