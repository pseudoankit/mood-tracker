package lostankit7.droid.moodtracker.data_layer.repository

import lostankit7.droid.moodtracker.data_layer.database.dao.SuggestedTaskIconDao
import lostankit7.droid.moodtracker.data_layer.database.entities.SuggestedTaskIcon
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SuggestedTaskIconRepository @Inject constructor(private val dao: SuggestedTaskIconDao) {

    val suggestedTaskIcon = dao.suggestedTaskIcons()

    suspend fun insertSuggestedTaskIcons(list: List<SuggestedTaskIcon>) = dao.insertSuggestedIcons(list)
}