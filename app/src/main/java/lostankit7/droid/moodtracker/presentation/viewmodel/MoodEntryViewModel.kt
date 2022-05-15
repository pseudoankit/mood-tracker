package lostankit7.droid.moodtracker.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.core_presentation.utils.entity.UiText
import lostankit7.droid.moodtracker.core_presentation.viewmodel.BaseViewModel
import lostankit7.android.entry_data.database.entities.MoodIcon
import lostankit7.android.entry_data.repository.MoodIconRepository
import lostankit7.android.entry_data.repository.SuggestedMoodIconRepository
import lostankit7.android.entry_data.repository.SuggestedMoodNameRepository
import javax.inject.Inject

class MoodEntryViewModel @Inject constructor(
    private val moodRepository: lostankit7.android.entry_data.repository.MoodIconRepository,
    private val suggestedMoodIconRepo: lostankit7.android.entry_data.repository.SuggestedMoodIconRepository,
    private val suggestedMoodNameRepository: lostankit7.android.entry_data.repository.SuggestedMoodNameRepository,
) : BaseViewModel() {

    private val _errorMessageLiveData = MutableLiveData<UiText>()
    val errorMessageLiveData: LiveData<UiText> get() = _errorMessageLiveData

    val suggestedMoodNamesLiveData get() = suggestedMoodNameRepository.suggestedMoodNames
    val moodIconsLiveData: LiveData<List<lostankit7.android.entry_data.database.entities.MoodIcon>> get() = moodRepository.moodIcons
    val suggestedMoodLiveData get() = suggestedMoodIconRepo.suggestedMoodIcons

    fun saveMoodIcon(moodName: String, moodIcon: String, iconId: Int?) {
        when {
            moodName.isBlank() -> {
                _errorMessageLiveData.value = UiText.ResourceString(R.string.enter_mood_name)
            }
            else -> {
                val icon =
                    lostankit7.android.entry_data.database.entities.MoodIcon(moodIcon, moodName)

                iconId?.let {
                    icon.id = it
                    updateMoodIcon(icon)
                } ?: insertMoodIcon(icon)
            }
        }
    }

    private fun insertMoodIcon(icon: lostankit7.android.entry_data.database.entities.MoodIcon) = launchIo {
        moodRepository.insertMoodIcon(icon)
    }

    fun deleteMoodIcon(icon: lostankit7.android.entry_data.database.entities.MoodIcon) = launchIo {
        moodRepository.deleteMoodIcon(icon)
    }

    private fun updateMoodIcon(icon: lostankit7.android.entry_data.database.entities.MoodIcon) = launchIo {
        moodRepository.updateMoodIcon(icon)
    }
}