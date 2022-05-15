package lostankit7.droid.moodtracker.data_layer.repository

import lostankit7.droid.moodtracker.data_layer.database.dao.SuggestedMoodNameDao
import lostankit7.droid.moodtracker.data_layer.database.entities.SuggestedMoodName
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SuggestedMoodNameRepository @Inject constructor(private val dao: SuggestedMoodNameDao) {

    val suggestedMoodNames = dao.getSuggestions()

    suspend fun insertSuggestions(list: List<SuggestedMoodName>) = dao.insertSuggestions(list)

    suspend fun insertSuggestion(it: SuggestedMoodName) = dao.insertSuggestion(it)

    suspend fun deleteSuggestion(it: SuggestedMoodName) = dao.deleteSuggestion(it)

}