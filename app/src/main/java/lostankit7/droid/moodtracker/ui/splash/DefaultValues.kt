package lostankit7.droid.moodtracker.ui.splash

import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMood
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.helper.constant.FontAwesomeIcon
import lostankit7.droid.moodtracker.helper.constant.MoodNames
import lostankit7.droid.moodtracker.helper.constant.dbEntrySeparator

object DefaultValues {

    fun suggestedMoodIcons() = listOf(
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

    fun moodIcons() = listOf(
        MoodIcon(FontAwesomeIcon.happy, MoodNames.happy),
        MoodIcon(FontAwesomeIcon.jolly, MoodNames.jolly),
        MoodIcon(FontAwesomeIcon.meh, MoodNames.meh),
        MoodIcon(FontAwesomeIcon.sad, MoodNames.sad),
        MoodIcon(FontAwesomeIcon.awful, MoodNames.awful),
    )

    fun taskCategories() = listOf(
        TaskCategory("Other"),
        TaskCategory("Entertainment")
    )
}