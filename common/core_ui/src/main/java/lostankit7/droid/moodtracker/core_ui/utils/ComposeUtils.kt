package lostankit7.droid.moodtracker.core_ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import lostankit7.droid.moodtracker.core_ui.compose.values.LocalSpacing

val spacing @Composable get() = LocalSpacing.current

val context @Composable get() = LocalContext.current