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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import lazycoder21.droid.compose.CircularFontAwesomeIcon
import lazycoder21.droid.compose.FaIcon
import lazycoder21.droid.compose.FaIcons
import lazycoder21.droid.compose.FontAwesomeIcon
import lostankit7.droid.moodtracker.core.domain.entities.shared.Icon.Companion.transformAsString
import lostankit7.droid.moodtracker.core.domain.entities.shared.UserEntry
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
fun DrawOptionMenu(item: UserEntry) {
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
fun DrawTasks(item: UserEntry) {
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
fun DrawMoodName(item: UserEntry) {
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
fun DrawEntryDetails(item: UserEntry) {
    val date = item.date
    val day = item.date.getDay()
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
                style = SpanStyle(color = SecondaryTextColor, fontSize = spacing.text.lvl6)
            ) {
                append(date)
            }
            append(" ")
            withStyle(
                style = SpanStyle(color = TimeColor, fontSize = spacing.text.lvl5)
            ) {
                append(time)
            }
        },
    )
}

@Composable
fun DrawMoodIcon(item: UserEntry) {
    FontAwesomeIcon(
        faIcon = FaIcon.Regular(item.moodIcon),
        size = spacing.userEntry.moodIconSize,
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
