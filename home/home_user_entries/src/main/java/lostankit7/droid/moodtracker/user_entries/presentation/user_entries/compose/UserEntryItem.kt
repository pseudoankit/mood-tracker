package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import lostankit7.droid.moodtracker.core.domain.entities.shared.UserEntry
import lostankit7.droid.moodtracker.core_ui.compose.values.Dimensions
import lostankit7.droid.moodtracker.core_ui.utils.spacing

private const val MOOD_ICON = "mood_icon"
private const val ENTRY_DETAILS = "entry_date"
private const val MOOD_NAME = "mood_name"
private const val TASKS = "tasks"
private const val OPTION_BUTTON = "option_btn"

@Composable
fun DrawUserEntryItem(
    item: UserEntry,
    modifier: Modifier = Modifier,
) {
    ConstraintLayout(
        constraintSet = createConstraints(spacing),
        modifier = Modifier
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
        DrawTasks()
        DrawOptionMenu()
    }
}

@Composable
fun DrawOptionMenu() {

}

@Composable
fun DrawTasks() {

}

@Composable
fun DrawMoodName(item: UserEntry) {

}

@Composable
fun DrawEntryDetails(item: UserEntry) {

}

@Composable
fun DrawMoodIcon(item: UserEntry) {

}


private fun createConstraints(spacing: Dimensions) = ConstraintSet {
    val moodIcon = createRefFor(MOOD_ICON)
    val entryDetails = createRefFor(ENTRY_DETAILS)
    val moodName = createRefFor(MOOD_NAME)
    val tasks = createRefFor(TASKS)
    val optionButton = createRefFor(OPTION_BUTTON)
    val leftGuide = createGuidelineFromAbsoluteLeft(spacing.dp_50)

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
