package lostankit7.android.entry_domain.repository


import androidx.lifecycle.LiveData
import lostankit7.android.entry_domain.entities.MoodIcon

interface MoodIconRepository {
    val moodIcons: LiveData<List<MoodIcon>>
    suspend fun insertMoodIcons(icons: List<MoodIcon>)
    suspend fun insertMoodIcon(icon: MoodIcon)
    suspend fun updateMoodIcon(icon: MoodIcon)
    suspend fun deleteMoodIcon(icon: MoodIcon)
}