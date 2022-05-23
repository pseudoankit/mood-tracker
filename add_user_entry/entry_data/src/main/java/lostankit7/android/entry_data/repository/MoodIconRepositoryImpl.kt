package lostankit7.android.entry_data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import lostankit7.android.entry_data.local.dao.MoodIconDao
import lostankit7.android.entry_data.mapper.MoodIconMapper.toLocalMoodIconInsert
import lostankit7.android.entry_data.mapper.MoodIconMapper.toLocalMoodIconUpdate
import lostankit7.android.entry_data.mapper.MoodIconMapper.toMoodIcon
import lostankit7.android.entry_domain.entities.MoodIcon
import lostankit7.android.entry_domain.repository.MoodIconRepository

class MoodIconRepositoryImpl(private val moodIconDao: MoodIconDao) : MoodIconRepository {

    override fun moodIcons(): LiveData<List<MoodIcon>> =
        moodIconDao.getMoodIcons().map { it.toMoodIcon() }

    override suspend fun insertMoodIcons(icons: List<MoodIcon>) {
        moodIconDao.insertMoodIcons(icons.toLocalMoodIconInsert())
    }

    override suspend fun insertMoodIcon(icon: MoodIcon) {
        moodIconDao.insertMoodIcon(icon.toLocalMoodIconInsert())
    }

    override suspend fun updateMoodIcon(icon: MoodIcon) {
        moodIconDao.updateMoodIcon(icon.toLocalMoodIconUpdate())
    }

    override suspend fun deleteMoodIcon(icon: MoodIcon) {
        moodIconDao.deleteMoodIcon(icon.toLocalMoodIconUpdate())
    }
}