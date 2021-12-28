package lostankit7.droid.moodtracker.ui.main.entry.mood

import android.content.Context
import androidx.lifecycle.ViewModel
import lostankit7.droid.moodtracker.helper.FontAwesomeIcon
import lostankit7.droid.moodtracker.helper.MoodNames
import lostankit7.droid.moodtracker.model.Icon
import javax.inject.Inject

class MoodEntryViewModel @Inject constructor() : ViewModel() {

    fun insertMoodIcon(icon: Icon) {

    }

    /** method which return mood icons stored in db*/
    fun getMoodIconList() = mutableListOf<Icon>().also {
        it.add(Icon(FontAwesomeIcon.happy, MoodNames.happy))
        it.add(Icon(FontAwesomeIcon.jolly, MoodNames.jolly))
        it.add(Icon(FontAwesomeIcon.meh, MoodNames.meh))
        it.add(Icon(FontAwesomeIcon.sad, MoodNames.sad))
        it.add(Icon(FontAwesomeIcon.awful, MoodNames.awful))
    }

    fun suggestedMoodIconList() = mutableListOf(
        Icon(FontAwesomeIcon.m01, ""),
        Icon(FontAwesomeIcon.m02, ""),
        Icon(FontAwesomeIcon.m03, ""),
        Icon(FontAwesomeIcon.m04, ""),
        Icon(FontAwesomeIcon.m05, ""),
        Icon(FontAwesomeIcon.m06, ""),
        Icon(FontAwesomeIcon.m07, ""),
        Icon(FontAwesomeIcon.m08, "")
    )
}