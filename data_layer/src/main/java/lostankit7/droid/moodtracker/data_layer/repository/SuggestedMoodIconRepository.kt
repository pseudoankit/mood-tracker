package lostankit7.droid.moodtracker.data_layer.repository

import lostankit7.droid.moodtracker.data_layer.database.dao.SuggestedMoodIconDao
import lostankit7.droid.moodtracker.data_layer.database.entities.SuggestedMoodIcon
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SuggestedMoodIconRepository @Inject constructor(private val dao: SuggestedMoodIconDao) {

    val suggestedMoodIcons = dao.suggestedMoodIcons()

    suspend fun insertSuggestedMoods(list: List<SuggestedMoodIcon>) = dao.insertSuggestions(list)
}