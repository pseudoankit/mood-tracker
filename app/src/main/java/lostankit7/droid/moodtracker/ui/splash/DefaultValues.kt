package lostankit7.droid.moodtracker.ui.splash

import android.content.Context
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMoodIcon
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon

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
        SuggestedMoodIcon("\uf5b8"),
        SuggestedMoodIcon("\uf5b3"),
        SuggestedMoodIcon("\uf5a4"),
        SuggestedMoodIcon("\uf59c"),
        SuggestedMoodIcon("\uf59a"),
        SuggestedMoodIcon("\uf598"),
        SuggestedMoodIcon("\uf58c"),
        SuggestedMoodIcon("\uf58b"),
        SuggestedMoodIcon("\uf589"),
        SuggestedMoodIcon("\uf588"),
        SuggestedMoodIcon("\uf587"),
        SuggestedMoodIcon("\uf586"),
        SuggestedMoodIcon("\uf585"),
        SuggestedMoodIcon("\uf584"),
        SuggestedMoodIcon("\uf583"),
        SuggestedMoodIcon("\uf582"),
        SuggestedMoodIcon("\uf581"),
        SuggestedMoodIcon("\uf580"),
        SuggestedMoodIcon("\uf57f"),
        SuggestedMoodIcon("\uf57a"),
        SuggestedMoodIcon("\uf579"),
        SuggestedMoodIcon("\uf556"),
        SuggestedMoodIcon("\uf5a5"),
        SuggestedMoodIcon("\uf5c8"),
        SuggestedMoodIcon("\uf5c2"),
        SuggestedMoodIcon("\uf4da"),
        SuggestedMoodIcon("\uf5b4"),
        SuggestedMoodIcon("\uf596"),
        SuggestedMoodIcon("\uf58a"),
        SuggestedMoodIcon("\uf118"),
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