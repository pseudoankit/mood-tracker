package lostankit7.droid.moodtracker.ui.splash

import android.content.Context
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMood
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.helper.constant.FontAwesomeIcon
import lostankit7.droid.moodtracker.helper.constant.MoodNames

object DefaultValues {

    fun taskIcons(context: Context): List<TaskIcon> = with(context.resources) {
        val list = mutableListOf<TaskIcon>()
        val cOther = getString(R.string.other)
        val cEntertainment = getString(R.string.entertainment)
        val cWork = getString(R.string.work)
        val cHealth = getString(R.string.health)


        list.add(TaskIcon("\uf4ce", getString(R.string.family), cOther))
        list.add(TaskIcon("\uf500", getString(R.string.friends), cOther))
        list.add(TaskIcon("\uf2e7", getString(R.string.food), cOther))
        list.add(TaskIcon("\uf1b9", getString(R.string.drive), cOther))
        list.add(TaskIcon("\uf518", getString(R.string.books), cOther))
        list.add(TaskIcon("\uf564", getString(R.string.cookies), cOther))
        list.add(TaskIcon("\uf679", getString(R.string.pray), cOther))


        list.add(TaskIcon("\uf07a", getString(R.string.shopping), cEntertainment))
        list.add(TaskIcon("\uf008", getString(R.string.movies), cEntertainment))
        list.add(TaskIcon("\uf11b", getString(R.string.gaming), cEntertainment))
        list.add(TaskIcon("\uf79f", getString(R.string.party), cEntertainment))


        list.add(TaskIcon("\uf84a", getString(R.string.cycling), cHealth))
        list.add(TaskIcon("\uf70c", getString(R.string.sports), cHealth))
        list.add(TaskIcon("\uf44b", getString(R.string.gym), cHealth))


        list.add(TaskIcon("\uf5fc", getString(R.string.code), cWork))
        list.add(TaskIcon("\uf188", getString(R.string.bug), cWork))

        return list
    }

    fun taskCategories(context: Context) = listOf(
        TaskCategory(context.resources.getString(R.string.work)),
        TaskCategory(context.resources.getString(R.string.entertainment)),
        TaskCategory(context.resources.getString(R.string.health)),
        TaskCategory(context.resources.getString(R.string.other))
    )

    fun suggestedMoodIcons() = listOf(
        SuggestedMood("\uf5b8"),
        SuggestedMood("\uf5b3"),
        SuggestedMood("\uf5a4"),
        SuggestedMood("\uf59c"),
        SuggestedMood("\uf59a"),
        SuggestedMood("\uf598"),
        SuggestedMood("\uf58c"),
        SuggestedMood("\uf58b"),
        SuggestedMood("\uf589"),
        SuggestedMood("\uf588"),
        SuggestedMood("\uf587"),
        SuggestedMood("\uf586"),
        SuggestedMood("\uf585"),
        SuggestedMood("\uf584"),
        SuggestedMood("\uf583"),
        SuggestedMood("\uf582"),
        SuggestedMood("\uf581"),
        SuggestedMood("\uf580"),
        SuggestedMood("\uf57f"),
        SuggestedMood("\uf57a"),
        SuggestedMood("\uf579"),
        SuggestedMood("\uf556"),
        SuggestedMood("\uf5a5"),
        SuggestedMood("\uf5c8"),
        SuggestedMood("\uf5c2"),
        SuggestedMood("\uf4da"),
        SuggestedMood("\uf5b4"),
        SuggestedMood("\uf596"),
        SuggestedMood("\uf58a"),
        SuggestedMood("\uf118"),
    )

    fun moodIcons(context: Context) = listOf(
        MoodIcon(MOOD_ICON_HAPPY, context.resources.getString(R.string.happy)),
        MoodIcon(MOOD_ICON_JOLLY, context.resources.getString(R.string.jolly)),
        MoodIcon(MOOD_ICON_MEH, context.resources.getString(R.string.meh)),
        MoodIcon(MOOD_ICON_SAD, context.resources.getString(R.string.sad)),
        MoodIcon(MOOD_ICON_AWFUL, context.resources.getString(R.string.awful)),
    )

    private const val MOOD_ICON_HAPPY = "\uf599"
    private const val MOOD_ICON_SAD = "\uf119"
    private const val MOOD_ICON_MEH = "\uf11a"
    private const val MOOD_ICON_AWFUL = "\uf567"
    private const val MOOD_ICON_JOLLY = "\uf59b"
}