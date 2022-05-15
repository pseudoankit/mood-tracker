package lostankit7.droid.moodtracker.utils

import android.content.Context
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.data_layer.database.entities.*

object SplashFragmentDataProvider {

    fun moodIcons(context: Context) = listOf(
        MoodIcon(MOOD_ICON_HAPPY, context.resources.getString(R.string.happy)),
        MoodIcon(MOOD_ICON_JOLLY, context.resources.getString(R.string.jolly)),
        MoodIcon(MOOD_ICON_MEH, context.resources.getString(R.string.meh)),
        MoodIcon(MOOD_ICON_SAD, context.resources.getString(R.string.sad)),
        MoodIcon(MOOD_ICON_AWFUL, context.resources.getString(R.string.awful)),
    )

    fun taskCategories(context: Context) = listOf(
        TaskCategory(context.resources.getString(R.string.work)),
        TaskCategory(context.resources.getString(R.string.entertainment)),
        TaskCategory(context.resources.getString(R.string.health)),
        TaskCategory(context.resources.getString(R.string.other))
    )

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
        list.add(TaskIcon("\uF5DA", getString(R.string.books), cOther))
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

    fun suggestedTaskIcons() = listOf(
        SuggestedTaskIcon("\uF2BB", "", true),
        SuggestedTaskIcon("\uF042", "", true),
        SuggestedTaskIcon("\uF5D0", "freshener", true),
        SuggestedTaskIcon("\uF461", "", true),
        SuggestedTaskIcon("\uF0F9", "ambulance", true),
        SuggestedTaskIcon("\uF2A3", "", true),
        SuggestedTaskIcon("\uF13D", "", true),
        SuggestedTaskIcon("\uF644", "", true),
        SuggestedTaskIcon("\uF2A2", "", true),
        SuggestedTaskIcon("\uF559", "award", true),
        SuggestedTaskIcon("\uF558", "web", true),
        SuggestedTaskIcon("\uF77C", "baby", true),
        SuggestedTaskIcon("\uF77D", "baby walk", true),
        SuggestedTaskIcon("\uE059", "bacteria", true),
        SuggestedTaskIcon("\uF666", "boom", true),
        SuggestedTaskIcon("\uF515", "balance", true),
        SuggestedTaskIcon("\uF05E", "off", true),
        SuggestedTaskIcon("\uF433", "baseball", true),
        SuggestedTaskIcon("\uF434", "basketball", true),
        SuggestedTaskIcon("\uF2CD", "bath", true),
        SuggestedTaskIcon("\uF244", "battery empty", true),
        SuggestedTaskIcon("\uF240", "battery full", true),
        SuggestedTaskIcon("\uF236", "bed", true),
        SuggestedTaskIcon("\uF0FC", "beer", true),
        SuggestedTaskIcon("\uF0F3", "bell", true),
        SuggestedTaskIcon("\uF1F6", "notification off", true),
        SuggestedTaskIcon("\uF647", "", true),
        SuggestedTaskIcon("\uF206", "bicycle", true),
        SuggestedTaskIcon("\uF780", "", true),
        SuggestedTaskIcon("\uF1FD", "birthday", true),
        SuggestedTaskIcon("\uF517", "", true),
        SuggestedTaskIcon("\uF0E7", "phone charging", true),
        SuggestedTaskIcon("\uF781", "blog", true),
        SuggestedTaskIcon("\uF5D7", "chicken", true),
        SuggestedTaskIcon("\uF1E2", "bomb", true),
        SuggestedTaskIcon("\uF55C", "", true),
        SuggestedTaskIcon("\uF518", "book", true),
        SuggestedTaskIcon("\uF436", "bowling ball", true),
        SuggestedTaskIcon("\uE05B", "tissue", true),
        SuggestedTaskIcon("\uF468", "puzzle", true),
        SuggestedTaskIcon("\uF469", "first aid", true),
        SuggestedTaskIcon("\uF519", "", true),
        SuggestedTaskIcon("\uF51A", "", true),
        SuggestedTaskIcon("\uF55D", "", true),
        SuggestedTaskIcon("\uF55E", "", true),
        SuggestedTaskIcon("\uF46A", "", true),
        SuggestedTaskIcon("\uF140", "shooting", true),
        SuggestedTaskIcon("\uF0A1", "announcement", true),
        SuggestedTaskIcon("\uF1AD", "building", true),
        SuggestedTaskIcon("\uF64A", "business", true),
        SuggestedTaskIcon("\uF274", "meeting done", true),
        SuggestedTaskIcon("\uF783", "meeting", true),
        SuggestedTaskIcon("\uF273", "no meeting", true),
        SuggestedTaskIcon("\uF6BB", "", true),
        SuggestedTaskIcon("\uF786", "hockey", true),
        SuggestedTaskIcon("\uF55F", "flower", true),
        SuggestedTaskIcon("\uF787", "carrot", true),
        SuggestedTaskIcon("\uF51C", "teaching", true),
        SuggestedTaskIcon("\uF6C0", "chair", true),
        SuggestedTaskIcon("\uF439", "chess", true),
        SuggestedTaskIcon("\uF51D", "church", true),
        SuggestedTaskIcon("\uF111", "blank dark", true),
        SuggestedTaskIcon("\uF64F", "city", true),
        SuggestedTaskIcon("\uF1CE", "blank", true),
        SuggestedTaskIcon("\uF7F2", "medical", true),
        SuggestedTaskIcon("\uF0C2", "cloud", true),
        SuggestedTaskIcon("\uF46D", "checklist", true),
        SuggestedTaskIcon("\uF46C", "done", true),
        SuggestedTaskIcon("\uF381", "cloud download", true),

        SuggestedTaskIcon("\uF73C", "cloud,true rainy", true),
        SuggestedTaskIcon("\uF73D", "rainy", true),
        SuggestedTaskIcon("\uF740", "heavy rain", true),
        SuggestedTaskIcon("\uF743", "cloud sunny rain", true),
        SuggestedTaskIcon("\uF6C4", "cloud sunny", true),

        SuggestedTaskIcon("\uF561", "cocktail", true),
        SuggestedTaskIcon("\uF121", "code", true),
        SuggestedTaskIcon("\uF075", "coin", true),
        SuggestedTaskIcon("\uF0F4", "coffee", true),
        SuggestedTaskIcon("\uF075", "message", true),
        SuggestedTaskIcon("\uF563", "cookie", true),
        SuggestedTaskIcon("\uF564", "cookie bite", true),
        SuggestedTaskIcon("\uF4B8", "couch", true),
        SuggestedTaskIcon("\uF564", "credit card", true),
        SuggestedTaskIcon("\uF05B", "aim", true),
        SuggestedTaskIcon("\uF1C0", "database", true),
        SuggestedTaskIcon("\uF655", "spider", true),
        SuggestedTaskIcon("\uF1B3", "cubes", true),
        SuggestedTaskIcon("\uF1B2", "cube", true),
        SuggestedTaskIcon("\uF0C4", "scissor", true),
        SuggestedTaskIcon("\uF521", "crown", true),
        SuggestedTaskIcon("\uF522", "dice", true),
        SuggestedTaskIcon("\uF6CF", "dice", true),
        SuggestedTaskIcon("\uF6D3", "dog", true),
        SuggestedTaskIcon("\uF471", "", true),
        SuggestedTaskIcon("\uF4BA", "bird", true),
        SuggestedTaskIcon("\uF569", "drum", true),
        SuggestedTaskIcon("\uF6D5", "dragon", true),
        SuggestedTaskIcon("\uF44B", "dumbell", true),
        SuggestedTaskIcon("\uF658", "envelope", true),
        SuggestedTaskIcon("\uF52D", "feather", true),
        SuggestedTaskIcon("\uF0FB", "flight", true),
        SuggestedTaskIcon("\uF576", "fill", true),
        SuggestedTaskIcon("\uF134", "fire extinguisher", true),
        SuggestedTaskIcon("\uF7E4", "fire", true),
        SuggestedTaskIcon("\uF578", "fish", true),
        SuggestedTaskIcon("\uF024", "flag", true),
        SuggestedTaskIcon("\uF44E", "football", true),
        SuggestedTaskIcon("\uF52F", "pump", true),
        SuggestedTaskIcon("\uF79C", "gift", true),
        SuggestedTaskIcon("\uF79C", "cheers", true),
        SuggestedTaskIcon("\uF6E3", "hammer", true),
        SuggestedTaskIcon("\uF7A6", "guitar", true),
        SuggestedTaskIcon("\uF4C1", "hand", true),
        SuggestedTaskIcon("\uF4C0", "hand", true),
        SuggestedTaskIcon("\uF8C1", "hat", true),
        SuggestedTaskIcon("\uF6EC", "hiking", true),
        SuggestedTaskIcon("\uF0F8", "hospital", true),
        SuggestedTaskIcon("\uF593", "tub", true),
        SuggestedTaskIcon("\uF593", "hotdog", true),
        SuggestedTaskIcon("\uF06C", "leaf", true),
        SuggestedTaskIcon("\uF094", "lemon", true),
        SuggestedTaskIcon("\uF0EB", "bulb", true),
        SuggestedTaskIcon("\uF21C", "bike", true),
        SuggestedTaskIcon("\uF1FC", "paint", true),
        SuggestedTaskIcon("\uF0C6", "paperclip", true),
        SuggestedTaskIcon("\uF5AB", "passport", true),
        SuggestedTaskIcon("\uF4D3", "bank", true),
        SuggestedTaskIcon("\uF818", "pizza", true),
        SuggestedTaskIcon("\uF70C", "running", true),
        SuggestedTaskIcon("\uF07A", "shopping", true),
        SuggestedTaskIcon("\uF290", "shopping", true),
        SuggestedTaskIcon("\uF2CC", "shower", true),
        SuggestedTaskIcon("\uF7C5", "staking", true),
        SuggestedTaskIcon("\uF7CA", "skiing", true),
        SuggestedTaskIcon("\uF48D", "smoke", true),
        SuggestedTaskIcon("\uF7D0", "snowman", true),
        SuggestedTaskIcon("\uF48E", "syringe", true),
        SuggestedTaskIcon("\uF769", "thermometer", true),
        SuggestedTaskIcon("\uF76B", "thermometer", true),
        SuggestedTaskIcon("\uF2C7", "thermometer", true),
        SuggestedTaskIcon("\uF491", "thermometer", true),
        SuggestedTaskIcon("\uF2C8", "thermometer", true),
        SuggestedTaskIcon("\uF164", "thumbs", true),
        SuggestedTaskIcon("\uF165", "thumbs", true),
        SuggestedTaskIcon("\uF722", "tractor", true),
        SuggestedTaskIcon("\uF637", "traffic", true),
        SuggestedTaskIcon("\uF7D9", "tools", true),
        SuggestedTaskIcon("\uF552", "toolbox", true),
        SuggestedTaskIcon("\uF238", "train", true)
    )

    fun suggestedMoodNames(context: Context): List<SuggestedMoodName> {
        val suggNames = context.resources.getStringArray(R.array.suggested_mood_names)
       return suggNames.map { SuggestedMoodName(it) }
    }

    fun suggestedTaskNames(context: Context) : List<SuggestedTaskName> {
        val suggNames = context.resources.getStringArray(R.array.suggested_task_names)
        return suggNames.map { SuggestedTaskName(it) }
    }

    private const val MOOD_ICON_HAPPY = "\uf599"
    private const val MOOD_ICON_SAD = "\uf119"
    private const val MOOD_ICON_MEH = "\uf11a"
    private const val MOOD_ICON_AWFUL = "\uf567"
    private const val MOOD_ICON_JOLLY = "\uf59b"
}