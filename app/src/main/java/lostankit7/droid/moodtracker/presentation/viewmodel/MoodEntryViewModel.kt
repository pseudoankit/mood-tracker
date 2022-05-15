package lostankit7.droid.moodtracker.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.entity.StringHandler
import lostankit7.droid.moodtracker.base.viewmodel.BaseViewModel
import lostankit7.droid.moodtracker.data_layer.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data_layer.repository.MoodIconRepository
import lostankit7.droid.moodtracker.data_layer.repository.SuggestedMoodIconRepository
import lostankit7.droid.moodtracker.data_layer.repository.SuggestedMoodNameRepository
import javax.inject.Inject

class MoodEntryViewModel @Inject constructor(
    private val moodRepository: MoodIconRepository,
    private val suggestedMoodIconRepo: SuggestedMoodIconRepository,
    private val suggestedMoodNameRepository: SuggestedMoodNameRepository,
) : BaseViewModel() {

    private val _errorMessageLiveData = MutableLiveData<StringHandler>()
    val errorMessageLiveData: LiveData<StringHandler> get() = _errorMessageLiveData

    val suggestedMoodNamesLiveData get() = suggestedMoodNameRepository.suggestedMoodNames
    val moodIconsLiveData: LiveData<List<MoodIcon>> get() = moodRepository.moodIcons
    val suggestedMoodLiveData get() = suggestedMoodIconRepo.suggestedMoodIcons

    fun saveMoodIcon(moodName: String, moodIcon: String, iconId: Int?) {
        when {
            moodName.isBlank() -> {
                _errorMessageLiveData.value = StringHandler.ResourceString(R.string.enter_mood_name)
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

    private fun insertMoodIcon(icon: MoodIcon) = launchIo {
        moodRepository.insertMoodIcon(icon)
    }

    fun deleteMoodIcon(icon: MoodIcon) = launchIo {
        moodRepository.deleteMoodIcon(icon)
    }

    private fun updateMoodIcon(icon: MoodIcon) = launchIo {
        moodRepository.updateMoodIcon(icon)
    }
}