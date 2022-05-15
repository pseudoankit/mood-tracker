package lostankit7.android.entry_domain.repository

import kotlinx.coroutines.flow.Flow
import lostankit7.android.entry_domain.entities.MoodIcon

interface MoodIconRepository {
    val moodIcons: Flow<List<MoodIcon>>
    suspend fun insertMoodIcons(icons: List<MoodIcon>)
    suspend fun insertMoodIcon(icon: MoodIcon)
    fun updateMoodIcon(icon: MoodIcon)
    fun deleteMoodIcon(icon: MoodIcon)
}