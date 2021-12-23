package lostankit7.droid.moodtracker.ui.main.newentry.mood

import android.content.Context
import androidx.lifecycle.ViewModel
import lostankit7.droid.moodtracker.helper.FontAwesomeIcon
import lostankit7.droid.moodtracker.helper.MoodNames
import lostankit7.droid.moodtracker.model.Icon
import javax.inject.Inject

class MoodEntryViewModel @Inject constructor() : ViewModel() {

    /** method which return mood icons stored in db*/
    fun getMoodIconList(context: Context) = mutableListOf<Icon>().also {
        context.resources.apply {
            it.add(Icon(FontAwesomeIcon.happy, MoodNames.happy))
            it.add(Icon(FontAwesomeIcon.jolly, MoodNames.jolly))
            it.add(Icon(FontAwesomeIcon.meh, MoodNames.meh))
            it.add(Icon(FontAwesomeIcon.sad, MoodNames.sad))
            it.add(Icon(FontAwesomeIcon.awful, MoodNames.awful))
        }
    }

}