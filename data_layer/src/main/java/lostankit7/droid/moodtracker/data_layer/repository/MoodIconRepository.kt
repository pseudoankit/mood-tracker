package lostankit7.droid.moodtracker.data_layer.repository

import lostankit7.droid.moodtracker.data_layer.database.dao.MoodIconDao
import lostankit7.droid.moodtracker.data_layer.database.entities.MoodIcon
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoodIconRepository @Inject constructor(private val moodIconDao: MoodIconDao) {

    val moodIcons = moodIconDao.getMoodIcons()

    suspend fun insertMoodIcons(icons: List<MoodIcon>) = moodIconDao.insertMoodIcons(icons)

    suspend fun insertMoodIcon(icon: MoodIcon) = moodIconDao.insertMoodIcon(icon)

    fun updateMoodIcon(icon: MoodIcon) = moodIconDao.updateMoodIcon(icon)

    fun deleteMoodIcon(icon: MoodIcon) = moodIconDao.deleteMoodIcon(icon)
}