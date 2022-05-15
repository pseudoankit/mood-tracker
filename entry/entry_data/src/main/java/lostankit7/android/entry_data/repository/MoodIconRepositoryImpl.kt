package lostankit7.android.entry_data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import lostankit7.android.entry_data.local.dao.MoodIconDao
import lostankit7.android.entry_data.local.entities.LocalMoodIcon
import lostankit7.android.entry_data.mapper.MoodIconMapper.toLocalMoodIconInsert
import lostankit7.android.entry_data.mapper.MoodIconMapper.toLocalMoodIconUpdate
import lostankit7.android.entry_data.mapper.MoodIconMapper.toMoodIcon
import lostankit7.android.entry_domain.entities.MoodIcon
import lostankit7.android.entry_domain.repository.MoodIconRepository

class MoodIconRepositoryImpl(private val moodIconDao: MoodIconDao) : MoodIconRepository {

    override val moodIcons: Flow<List<MoodIcon>> =
        moodIconDao.getMoodIcons().map { it.toMoodIcon() }

    override suspend fun insertMoodIcons(icons: List<MoodIcon>) {
        moodIconDao.insertMoodIcons(icons.toLocalMoodIconInsert())
    }

    override suspend fun insertMoodIcon(icon: MoodIcon) {
        moodIconDao.insertMoodIcon(icon.toLocalMoodIconInsert())
    }

    override fun updateMoodIcon(icon: MoodIcon) {
        moodIconDao.updateMoodIcon(icon.toLocalMoodIconUpdate())
    }

    override fun deleteMoodIcon(icon: MoodIcon) {
        moodIconDao.deleteMoodIcon(icon.toLocalMoodIconUpdate())
    }
}