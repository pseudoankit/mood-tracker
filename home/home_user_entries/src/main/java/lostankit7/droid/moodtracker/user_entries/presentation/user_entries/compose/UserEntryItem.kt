package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import lazycoder21.droid.compose.CircularFontAwesomeIcon
import lazycoder21.droid.compose.FaIcon
import lazycoder21.droid.compose.FaIcons
import lazycoder21.droid.compose.FontAwesomeIcon
import lostankit7.droid.moodtracker.core.domain.entities.shared.Icon.Companion.transformAsString
import lostankit7.droid.moodtracker.core.domain.entities.shared.UserEntry
import lostankit7.droid.moodtracker.core_ui.compose.values.*
import lostankit7.droid.moodtracker.core_ui.utils.spacing

private const val LAYOUT_MOOD_ICON = "mood_icon"
private const val LAYOUT_ENTRY_DETAILS = "entry_date"
private const val LAYOUT_MOOD_NAME = "mood_name"
private const val LAYOUT_TASKS = "tasks"
private const val LAYOUT_OPTION_BUTTON = "option_btn"
private const val LAYOUT_NOTES = "notes"

@Composable
fun DrawUserEntryItem(
    item: UserEntry,
    modifier: Modifier = Modifier,
) {
    ConstraintLayout(
        constraintSet = createConstraints(spacing),
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(spacing.cornerRadius)
            )
            .padding(spacing.dp_10)
    ) {
        DrawMoodIcon(item)
        DrawEntryDetails(item)
        DrawMoodName(item)
        DrawTasks(item)
        DrawNotes(item)
        DrawOptionMenu(item)
    }
}

@Composable
fun DrawNotes(item: UserEntry) {
    if (item.note.isBlank()) return

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId(LAYOUT_NOTES),
        text = item.note,
        fontSize = spacing.text.lvl4,
        color = SecondaryTextColor,
    )
}

@Composable
fun DrawOptionMenu(item: UserEntry) {
    CircularFontAwesomeIcon(
        icon = FaIcons.EllipsisH,
        modifier = Modifier
            .layoutId(LAYOUT_OPTION_BUTTON),
        size = spacing.optionMenuSize,
        tint = SecondaryIconColor,
        strokeWidth = spacing.strokeLvl1
    )
}

@Composable
fun DrawTasks(item: UserEntry) {
    if (item.taskIcons.isEmpty()) return

    FontAwesomeIcon(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId(LAYOUT_TASKS),
        faIcon = FaIcon.Solid(item.taskIcons.transformAsString),
        size = spacing.dp_18,
        tint = UserEntryTaskColor
    )
}

@Composable
fun DrawMoodName(item: UserEntry) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId(LAYOUT_MOOD_NAME),
        text = item.moodName,
        fontSize = spacing.text.lvl6,
        color = MoodIconColor
    )
}

@Composable
fun DrawEntryDetails(item: UserEntry) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId(LAYOUT_ENTRY_DETAILS),
        text = item.date,
        fontSize = spacing.text.lvl3
    )
}

@Composable
fun DrawMoodIcon(item: UserEntry) {
    FontAwesomeIcon(
        faIcon = FaIcon.Regular(item.moodIcon),
        size = 45.dp,
        tint = MoodIconColor
    )
}


private fun createConstraints(spacing: Dimensions) = ConstraintSet {
    val moodIcon = createRefFor(LAYOUT_MOOD_ICON)
    val entryDetails = createRefFor(LAYOUT_ENTRY_DETAILS)
    val moodName = createRefFor(LAYOUT_MOOD_NAME)
    val tasks = createRefFor(LAYOUT_TASKS)
    val optionButton = createRefFor(LAYOUT_OPTION_BUTTON)
    val leftGuide = createGuidelineFromStart(spacing.dp_50)
    val notes = createRefFor(LAYOUT_NOTES)

    constrain(notes) {
        top.linkTo(tasks.bottom)
        start.linkTo(leftGuide)
    }
    constrain(moodIcon) {
        top.linkTo(parent.top)
        start.linkTo(parent.start)
    }
    constrain(entryDetails) {
        start.linkTo(leftGuide)
        top.linkTo(parent.top)
    }
    constrain(moodName) {
        start.linkTo(leftGuide)
        top.linkTo(entryDetails.bottom)
    }
    constrain(tasks) {
        start.linkTo(leftGuide)
        top.linkTo(moodName.bottom)
    }
    constrain(optionButton) {
        end.linkTo(parent.end)
        top.linkTo(parent.top)
    }
}
