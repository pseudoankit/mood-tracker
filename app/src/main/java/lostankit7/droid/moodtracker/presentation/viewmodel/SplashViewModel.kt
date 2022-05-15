package lostankit7.droid.moodtracker.presentation.viewmodel

import lostankit7.droid.moodtracker.base.viewmodel.BaseViewModel
import lostankit7.droid.moodtracker.data_layer.database.entities.*
import lostankit7.droid.moodtracker.data_layer.repository.*
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val prefs: SharedPrefsRepository,
    private val moodIconRepo: MoodIconRepository,
    private val suggestedMoodIconRepo: SuggestedMoodIconRepository,
    private val suggestedTaskIconRepository: SuggestedTaskIconRepository,
    private val taskCategoryRepo: TaskCategoryRepository,
    private val taskIconRepo: TaskIconRepository,
    private val suggestedMoodNameRep: SuggestedMoodNameRepository,
    private val suggestedTaskNameRepository: SuggestedTaskNameRepository
) : BaseViewModel() {

    fun saveDefaultIcons(
        moodIcons: List<MoodIcon>,
        suggestedMoodIcons: List<SuggestedMoodIcon>,
        taskCategories: List<TaskCategory>,
        taskIcons: List<TaskIcon>,
        suggestedTaskIcons: List<SuggestedTaskIcon>,
        suggestedMoodNames: List<SuggestedMoodName>,
        suggestedTaskNames: List<SuggestedTaskName>
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