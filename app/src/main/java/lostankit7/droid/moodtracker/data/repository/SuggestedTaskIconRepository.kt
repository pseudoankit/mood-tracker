package lostankit7.droid.moodtracker.data.repository

import lostankit7.droid.moodtracker.data.database.dao.SuggestedTaskIconDao
import lostankit7.droid.moodtracker.data.database.entities.SuggestedTaskIcon
import javax.inject.Inject

class SuggestedTaskIconRepository @Inject constructor(private val dao: SuggestedTaskIconDao) {

    val suggestedTaskIcon = dao.suggestedTaskIcons()

    suspend fun insertSuggestedTaskIcons(list: List<SuggestedTaskIcon>) = dao.insertSuggestedIcons(list)
}