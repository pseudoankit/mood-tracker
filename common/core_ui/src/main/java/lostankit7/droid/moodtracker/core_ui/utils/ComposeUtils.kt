package lostankit7.droid.moodtracker.core_ui.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import lostankit7.droid.moodtracker.core_ui.compose.values.LocalSpacing

@ExperimentalComposeUiApi
val keyboardController
    @Composable get() = LocalSoftwareKeyboardController.current

val spacing @Composable get() = LocalSpacing.current

val context @Composable get() = LocalContext.current

inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}

@ExperimentalComposeUiApi
fun SoftwareKeyboardController.update(open: Boolean) {
    if (open) show() else hide()
}