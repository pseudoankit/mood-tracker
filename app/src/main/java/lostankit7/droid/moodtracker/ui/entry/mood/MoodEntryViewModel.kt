package lostankit7.droid.moodtracker.ui.entry.mood

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import lostankit7.droid.moodtracker.base.BaseViewModel
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMood
import lostankit7.droid.moodtracker.data.repository.MoodRepository
import javax.inject.Inject

class MoodEntryViewModel @Inject constructor(
    private val moodRepository: MoodRepository
) : BaseViewModel() {

    val moodIcons: LiveData<List<MoodIcon>>
        get() = moodRepository.moodIcons

    val suggestedMood: LiveData<List<SuggestedMood>>
        get() = moodRepository.suggestedMoodIcons

    fun insertMoodIcon(icon: MoodIcon) = launchIo {
        moodRepository.insertMoodIcon(icon)
    }

    fun deleteMoodIcon(icon: MoodIcon) = launchIo {
        moodRepository.deleteMoodIcon(icon)
    }

    fun updateMoodIcon(icon: MoodIcon) = launchIo {
        moodRepository.updateMoodIcon(icon)
    }
}