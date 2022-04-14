package lostankit7.droid.moodtracker.ui.viewmodel

import androidx.lifecycle.LiveData
import lostankit7.droid.moodtracker.base.viewmodel.BaseViewModel
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMoodIcon
import lostankit7.droid.moodtracker.data.repository.MoodIconRepository
import lostankit7.droid.moodtracker.data.repository.SuggestedMoodIconRepository
import lostankit7.droid.moodtracker.data.repository.SuggestedMoodNameRepository
import javax.inject.Inject

class MoodEntryViewModel @Inject constructor(
    private val moodRepository: MoodIconRepository,
    private val suggestedMoodIconRepo: SuggestedMoodIconRepository,
    private val suggestedMoodNameRepository: SuggestedMoodNameRepository
) : BaseViewModel() {

    val suggestedMoodNames = suggestedMoodNameRepository.suggestedMoodNames
    val moodIcons: LiveData<List<MoodIcon>>
        get() = moodRepository.moodIcons

    val suggestedMood: LiveData<List<SuggestedMoodIcon>>
        get() = suggestedMoodIconRepo.suggestedMoodIcons

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