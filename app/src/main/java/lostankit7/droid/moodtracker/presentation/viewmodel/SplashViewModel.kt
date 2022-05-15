package lostankit7.droid.moodtracker.presentation.viewmodel

import lostankit7.droid.moodtracker.core_presentation.viewmodel.BaseViewModel
import lostankit7.droid.moodtracker.data.database.entities.*
import lostankit7.droid.moodtracker.data.repository.*
import lostankit7.droid.moodtracker.domain.preferences.Preferences
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val prefs: Preferences,
    private val moodIconRepo: lostankit7.android.entry_data.repository.MoodIconRepository,
    private val suggestedMoodIconRepo: lostankit7.android.entry_data.repository.SuggestedMoodIconRepository,
    private val suggestedTaskIconRepository: lostankit7.android.entry_data.repository.SuggestedTaskIconRepository,
    private val taskCategoryRepo: lostankit7.android.entry_data.repository.TaskCategoryRepository,
    private val taskIconRepo: lostankit7.android.entry_data.repository.TaskIconRepository,
    private val suggestedMoodNameRep: lostankit7.android.entry_data.repository.SuggestedMoodNameRepository,
    private val suggestedTaskNameRepository: lostankit7.android.entry_data.repository.SuggestedTaskNameRepository
) : BaseViewModel() {

    fun saveDefaultIcons(
        moodIcons: List<lostankit7.android.entry_data.database.entities.MoodIcon>,
        suggestedMoodIcons: List<lostankit7.android.entry_data.database.entities.SuggestedMoodIcon>,
        taskCategories: List<lostankit7.android.entry_data.database.entities.TaskCategory>,
        taskIcons: List<lostankit7.android.entry_data.database.entities.TaskIcon>,
        suggestedTaskIcons: List<lostankit7.android.entry_data.database.entities.SuggestedTaskIcon>,
        suggestedMoodNames: List<lostankit7.android.entry_data.database.entities.SuggestedMoodName>,
        suggestedTaskNames: List<lostankit7.android.entry_data.database.entities.SuggestedTaskName>
    ) {
        if (!prefs.isInitialLaunch()) return

        launchIo {
            moodIconRepo.insertMoodIcons(moodIcons)
            suggestedMoodIconRepo.insertSuggestedMoods(suggestedMoodIcons)
            taskCategoryRepo.insertTaskCategories(taskCategories)
            taskIconRepo.insertTaskIcons(taskIcons)
            suggestedTaskIconRepository.insertSuggestedTaskIcons(suggestedTaskIcons)
            suggestedMoodNameRep.insertSuggestions(suggestedMoodNames)
            suggestedTaskNameRepository.insertSuggestions(suggestedTaskNames)
        }
        //todo if insertion fails
        prefs.isInitialLaunch(false)
    }
}