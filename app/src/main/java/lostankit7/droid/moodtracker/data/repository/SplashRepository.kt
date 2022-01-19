package lostankit7.droid.moodtracker.data.repository

import lostankit7.droid.moodtracker.data.database.dao.MoodIconDao
import lostankit7.droid.moodtracker.data.database.dao.SuggestedMoodDao
import lostankit7.droid.moodtracker.data.database.dao.TaskCategoryDao
import lostankit7.droid.moodtracker.data.database.dao.TaskIconDao
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMoodIcon
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import javax.inject.Inject

class SplashRepository @Inject constructor(
    private val moodIconDao: MoodIconDao,
    private val suggestedMoodDao: SuggestedMoodDao,
    private val taskCategoryDao: TaskCategoryDao,
    private val taskIconDao: TaskIconDao
) {

    suspend fun insertTaskIcons(list: List<TaskIcon>) = taskIconDao.insertTaskIcons(list)

    suspend fun insertTaskCategories(list: List<TaskCategory>) =
        taskCategoryDao.insertTaskCategories(list)

    suspend fun insertMoodIcons(icons: List<MoodIcon>) = moodIconDao.insertMoodIcons(icons)

    suspend fun insertSuggestedMoods(list: List<SuggestedMoodIcon>) =
        suggestedMoodDao.insertSuggestions(list)
}