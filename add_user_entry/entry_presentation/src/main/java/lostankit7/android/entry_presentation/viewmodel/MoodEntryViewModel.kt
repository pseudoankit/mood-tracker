package lostankit7.android.entry_presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import lostankit7.android.entry_domain.entities.MoodIcon
import lostankit7.android.entry_domain.repository.MoodIconRepository
import lostankit7.android.entry_domain.repository.SuggestedMoodIconRepository
import lostankit7.android.entry_domain.repository.SuggestedMoodNameRepository
import lostankit7.android.entry_presentation.R
import lostankit7.droid.moodtracker.core.domain.entities.common.UiText
import lostankit7.droid.moodtracker.core.presentation.base.viewmodel.BaseViewModel
import javax.inject.Inject

class MoodEntryViewModel @Inject constructor(
    private val moodRepository: MoodIconRepository,
    private val suggestedMoodIconRepo: SuggestedMoodIconRepository,
    private val suggestedMoodNameRepository: SuggestedMoodNameRepository,
) : BaseViewModel() {

    private val _errorMessageLiveData = MutableLiveData<UiText>()
    val errorMessageLiveData: LiveData<UiText> get() = _errorMessageLiveData

    val suggestedMoodNamesLiveData get() = suggestedMoodNameRepository.suggestedMoodNames
    val moodIconsLiveData: LiveData<List<MoodIcon>> get() = moodRepository.moodIcons()
    val suggestedMoodLiveData get() = suggestedMoodIconRepo.suggestedMoodIcons

    fun saveMoodIcon(moodName: String, moodIcon: String, iconId: Int?) {
        when {
            moodName.isBlank() -> {
                _errorMessageLiveData.value = UiText.ResourceString(R.string.enter_mood_name)
            }
            else -> {
                val icon = MoodIcon(moodIcon, moodName)

                iconId?.let {
                    icon.id = it
                    updateMoodIcon(icon)
                } ?: insertMoodIcon(icon)
            }
        }
    }

    private fun insertMoodIcon(icon: MoodIcon) =
        launchIo {
            moodRepository.insertMoodIcon(icon)
        }

    fun deleteMoodIcon(icon: MoodIcon) = launchIo {
        moodRepository.deleteMoodIcon(icon)
    }

    private fun updateMoodIcon(icon: MoodIcon) =
        launchIo {
            moodRepository.updateMoodIcon(icon)
        }
}