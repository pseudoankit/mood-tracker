package lostankit7.droid.moodtracker.data.repository

import lostankit7.droid.moodtracker.data.database.dao.SuggestedMoodNameDao
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMoodName
import javax.inject.Inject

class SuggestedMoodNameRepository @Inject constructor(private val dao: SuggestedMoodNameDao) {

    val suggestedMoodNames = dao.getSuggestions()

    suspend fun insertSuggestions(list: List<SuggestedMoodName>) = dao.insertSuggestions(list)

    suspend fun insertSuggestion(it: SuggestedMoodName) = dao.insertSuggestion(it)

    suspend fun deleteSuggestion(it: SuggestedMoodName) = dao.deleteSuggestion(it)

}