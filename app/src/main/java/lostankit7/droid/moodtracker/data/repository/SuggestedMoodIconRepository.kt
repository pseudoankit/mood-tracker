package lostankit7.droid.moodtracker.data.repository

import lostankit7.droid.moodtracker.data.database.dao.SuggestedMoodIconDao
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMoodIcon
import javax.inject.Inject

class SuggestedMoodIconRepository @Inject constructor(private val dao: SuggestedMoodIconDao) {

    val suggestedMoodIcons = dao.suggestedMoodIcons()

    suspend fun insertSuggestedMoods(list: List<SuggestedMoodIcon>) = dao.insertSuggestions(list)
}