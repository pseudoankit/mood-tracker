package lostankit7.droid.moodtracker.data_layer.repository

import lostankit7.droid.moodtracker.data_layer.database.dao.SuggestedTaskNameDao
import lostankit7.droid.moodtracker.data_layer.database.entities.SuggestedTaskName
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SuggestedTaskNameRepository @Inject constructor(private val dao: SuggestedTaskNameDao) {

    val suggestedNames = dao.getSuggestions()

    suspend fun insertSuggestions(list: List<SuggestedTaskName>) = dao.insertSuggestions(list)

    suspend fun insertSuggestion(it: SuggestedTaskName) = dao.insertSuggestion(it)

    suspend fun deleteSuggestion(it: SuggestedTaskName) = dao.deleteSuggestion(it)

}