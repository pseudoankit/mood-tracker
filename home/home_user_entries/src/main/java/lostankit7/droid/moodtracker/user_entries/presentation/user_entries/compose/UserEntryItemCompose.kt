package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import lazycoder21.droid.compose.CircularFontAwesomeIcon
import lazycoder21.droid.compose.FaIcon
import lazycoder21.droid.compose.FaIcons
import lazycoder21.droid.compose.FontAwesomeIcon
import lostankit7.android.entry_domain.entities.UserEntry
import lostankit7.droid.moodtracker.core.domain.entities.shared.Icon.Companion.transformAsString
import lostankit7.droid.moodtracker.core.presentation.utils.DateTimeUtils.getDay
import lostankit7.droid.moodtracker.core_ui.compose.values.*
import lostankit7.droid.moodtracker.core_ui.utils.context
import lostankit7.droid.moodtracker.core_ui.utils.spacing
import lostankit7.droid.moodtracker.user_entries.R

private const val LAYOUT_MOOD_ICON = "mood_icon"
private const val LAYOUT_ENTRY_DETAILS = "entry_date"
private const val LAYOUT_MOOD_NAME = "mood_name"
private const val LAYOUT_TASKS = "tasks"
private const val LAYOUT_OPTION_BUTTON = "option_btn"
private const val LAYOUT_NOTES = "notes"
private const val LAYOUT_LEFT_STROKE = "left_stroke"
private const val LAYOUT_RIGHT_STROKE = "right_stroke"

@Composable
fun DrawUserEntries(
    item: UserEntry.Entry,
    modifier: Modifier = Modifier,
) {
    ConstraintLayout(
        constraintSet = createConstraints(spacing),
        modifier = modifier
    ) {
        DrawLeftBorder()
        DrawMoodIcon(item)
        DrawEntryDetails(item)
        DrawMoodName(item)
        DrawTasks(item)
        DrawNotes(item)
        DrawOptionMenu(item)
        DrawRightBorder()
    }
}

@Composable
private fun DrawNotes(item: UserEntry.Entry) {
    if (item.notes.isBlank()) return

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId(LAYOUT_NOTES),
        text = context.getString(R.string.notes_prefix) + item.notes,
        fontSize = spacing.text.lvl7,
        color = SecondaryTextColor,
    )
}

@Composable
private fun DrawOptionMenu(item: UserEntry.Entry) {
    CircularFontAwesomeIcon(
        icon = FaIcons.EllipsisH,
        modifier = Modifier
            .layoutId(LAYOUT_OPTION_BUTTON),
        size = spacing.userEntry.optionMenuSize,
        tint = SecondaryIconColor,
        strokeWidth = spacing.strokeLvl1
    )
}

@Composable
private fun DrawTasks(item: UserEntry.Entry) {
    val taskIcons = item.taskIcons.transformAsString
    if (taskIcons.isBlank()) return

    FontAwesomeIcon(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId(LAYOUT_TASKS),
        faIcon = FaIcon.Solid(taskIcons),
        size = spacing.dp_18,
        tint = UserEntryTaskColor
    )
}

@Composable
private fun DrawMoodName(item: UserEntry.Entry) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId(LAYOUT_MOOD_NAME),
        text = item.moodName,
        fontSize = spacing.text.lvl8,
        color = MoodIconColor
    )
}

@Composable
private fun DrawEntryDetails(item: UserEntry.Entry) {
    val date = item.date
    val day = item.date.getDay
    val time = item.time

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId(LAYOUT_ENTRY_DETAILS),
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(color = PrimaryTextColor, fontSize = spacing.text.lvl8)
            ) {
                append(day)
            }
            append(", ")
            withStyle(
                style = SpanStyle(color = TimeColor, fontSize = spacing.text.lvl5)
            ) {
                append(time)
            }
        },
    )
}

@Composable
private fun DrawMoodIcon(item: UserEntry.Entry) {
    FontAwesomeIcon(
        faIcon = FaIcon.Regular(item.moodIcon),
        size = spacing.userEntry.moodIconSize,
        tint = MoodIconColor,
        modifier = Modifier.layoutId(LAYOUT_MOOD_ICON)
    )
}

@Composable
fun DrawLeftBorder() {
    Card(
        elevation = spacing.elevationLow,
        modifier = Modifier
            .layoutId(LAYOUT_LEFT_STROKE)
            .width(spacing.strokeLvl1),
    ) {}
}

@Composable
fun DrawRightBorder() {
    Card(
        elevation = spacing.elevationLow,
        modifier = Modifier
            .layoutId(LAYOUT_RIGHT_STROKE)
            .width(spacing.strokeLvl1),
    ) {}
}


private fun createConstraints(spacing: Dimensions) = ConstraintSet {
    val moodIcon = createRefFor(LAYOUT_MOOD_ICON)
    val entryDetails = createRefFor(LAYOUT_ENTRY_DETAILS)
    val moodName = createRefFor(LAYOUT_MOOD_NAME)
    val tasks = createRefFor(LAYOUT_TASKS)
    val optionButton = createRefFor(LAYOUT_OPTION_BUTTON)
    val notes = createRefFor(LAYOUT_NOTES)
    val leftBorder = createRefFor(LAYOUT_LEFT_STROKE)
    val rightBorder = createRefFor(LAYOUT_RIGHT_STROKE)

    val leftGuide = createGuidelineFromStart(spacing.dp_4)
    val rightGuide = createGuidelineFromEnd(spacing.dp_4)
    val moodIconGuide = createGuidelineFromStart(spacing.dp_50)
    val topGuide = createGuidelineFromTop(spacing.dp_8)

    val borderMargin = spacing.dp_0

    constrain(leftBorder) {
        start.linkTo(parent.start)
        top.linkTo(parent.top, borderMargin)
        bottom.linkTo(parent.bottom, borderMargin)
        height = Dimension.fillToConstraints
    }
    constrain(rightBorder) {
        start.linkTo(parent.end)
        top.linkTo(parent.top, borderMargin)
        bottom.linkTo(parent.bottom, borderMargin)
        height = Dimension.fillToConstraints
    }
    constrain(notes) {
        top.linkTo(tasks.bottom)
        start.linkTo(moodIconGuide)
    }
    constrain(moodIcon) {
        top.linkTo(topGuide)
        start.linkTo(leftGuide)
    }
    constrain(entryDetails) {
        start.linkTo(moodIconGuide)
        top.linkTo(topGuide)
    }
    constrain(moodName) {
        start.linkTo(moodIconGuide)
        top.linkTo(entryDetails.bottom)
    }
    constrain(tasks) {
        start.linkTo(moodIconGuide)
        top.linkTo(moodName.bottom)
    }
    constrain(optionButton) {
        end.linkTo(rightGuide)
        top.linkTo(topGuide)
    }
}
