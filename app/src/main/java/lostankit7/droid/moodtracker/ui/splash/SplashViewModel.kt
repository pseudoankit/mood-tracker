package lostankit7.droid.moodtracker.ui.splash

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMood
import lostankit7.droid.moodtracker.data.repository.MoodRepository
import lostankit7.droid.moodtracker.data.storage.SharedPrefs.get
import lostankit7.droid.moodtracker.data.storage.SharedPrefs.set
import lostankit7.droid.moodtracker.helper.constant.FontAwesomeIcon
import lostankit7.droid.moodtracker.helper.constant.IS_INITIAL_LAUNCH
import lostankit7.droid.moodtracker.helper.constant.MoodNames
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val prefs: SharedPreferences,
    private val moodRepository: MoodRepository
) : ViewModel() {

    fun saveDefaultIcons() {
        if (!prefs[IS_INITIAL_LAUNCH, true]) return

        val moodIcons = defaultMoodIcons()
        viewModelScope.launch(Dispatchers.IO) {
            val inserted = moodRepository.insertMoodIcons(moodIcons)
            moodRepository.insertSuggestedMoods(suggestedMoodIcons())
        }
        //todo if insertion fails
        prefs[IS_INITIAL_LAUNCH] = false
    }

    private fun suggestedMoodIcons() = listOf(
        SuggestedMood(FontAwesomeIcon.m01),
        SuggestedMood(FontAwesomeIcon.m02),
        SuggestedMood(FontAwesomeIcon.m03),
        SuggestedMood(FontAwesomeIcon.m04),
        SuggestedMood(FontAwesomeIcon.m05),
        SuggestedMood(FontAwesomeIcon.m06),
        SuggestedMood(FontAwesomeIcon.m07),
        SuggestedMood(FontAwesomeIcon.m08),
        SuggestedMood(FontAwesomeIcon.m09),
        SuggestedMood(FontAwesomeIcon.m10),
        SuggestedMood(FontAwesomeIcon.m11),
        SuggestedMood(FontAwesomeIcon.m12),
        SuggestedMood(FontAwesomeIcon.m13),
        SuggestedMood(FontAwesomeIcon.m14),
        SuggestedMood(FontAwesomeIcon.m15),
        SuggestedMood(FontAwesomeIcon.m16),
        SuggestedMood(FontAwesomeIcon.m17),
        SuggestedMood(FontAwesomeIcon.m18),
        SuggestedMood(FontAwesomeIcon.m19),
        SuggestedMood(FontAwesomeIcon.m20),
        SuggestedMood(FontAwesomeIcon.m21),
        SuggestedMood(FontAwesomeIcon.m22),
        SuggestedMood(FontAwesomeIcon.m23),
        SuggestedMood(FontAwesomeIcon.m24),
        SuggestedMood(FontAwesomeIcon.m25),
        SuggestedMood(FontAwesomeIcon.m26),
        SuggestedMood(FontAwesomeIcon.m27),
        SuggestedMood(FontAwesomeIcon.m28),
        SuggestedMood(FontAwesomeIcon.m29),
        SuggestedMood(FontAwesomeIcon.m30),
    )

    private fun defaultMoodIcons() = listOf(
        MoodIcon(FontAwesomeIcon.happy, MoodNames.happy),
        MoodIcon(FontAwesomeIcon.jolly, MoodNames.jolly),
        MoodIcon(FontAwesomeIcon.meh, MoodNames.meh),
        MoodIcon(FontAwesomeIcon.sad, MoodNames.sad),
        MoodIcon(FontAwesomeIcon.awful, MoodNames.awful),
    )
}