package lostankit7.droid.moodtracker.ui.splash

import android.content.Context
import lostankit7.droid.moodtracker.base.BaseViewModel
import lostankit7.droid.moodtracker.data.repository.*
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val prefs: SharedPrefsRepository,
    private val moodIconRepo: MoodIconRepository,
    private val suggestedMoodIconRepo: SuggestedMoodIconRepository,
    private val taskCategoryRepo: TaskCategoryRepository,
    private val taskIconRepo: TaskIconRepository
) : BaseViewModel() {

    //todo check for context in view model
    fun saveDefaultIcons(context: Context) {
        if (!prefs.isInitialLaunch()) return

        launchIo {
            moodIconRepo.insertMoodIcons(DefaultValues.moodIcons(context))
            suggestedMoodIconRepo.insertSuggestedMoods(DefaultValues.suggestedMoodIcons())
            taskCategoryRepo.insertTaskCategories(DefaultValues.taskCategories(context))
            taskIconRepo.insertTaskIcons(DefaultValues.taskIcons(context))
        }
        //todo if insertion fails
        prefs.isInitialLaunch(false)
    }
}