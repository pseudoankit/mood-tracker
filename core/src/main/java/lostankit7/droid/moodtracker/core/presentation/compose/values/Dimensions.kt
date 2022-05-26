package lostankit7.droid.moodtracker.core.presentation.compose.values

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Dimensions(
    val default: Dp = 0.dp,
    val screenPadding: Dp = 10.dp,
    val stdHeight: Dp = 45.dp,
    val defButtonHeight: Dp = 40.dp,
    val cornerRadius: Dp = 8.dp,
    val elevation: Dp = 3.dp,
    val dp_1: Dp = 1.dp,
    val dp_2: Dp = 2.dp,
    val dp_3: Dp = 3.dp,
    val dp_4: Dp = 4.dp,
    val dp_5: Dp = 5.dp,
    val dp_7: Dp = 7.dp,
    val dp_10: Dp = 10.dp,
    val dp_15: Dp = 15.dp,
    val dp_30: Dp = 30.dp,
    val dp_35: Dp = 35.dp,
    val dp_50: Dp = 50.dp,
    val dp_65: Dp = 65.dp,
    val text: Text = Text(),
) {
    data class Text(
        val xSmall: TextUnit = 8.sp,
        val small: TextUnit = 11.sp,
        val medium: TextUnit = 15.sp,
        val header: TextUnit = 22.sp,
    )
}

val LocalSpacing = compositionLocalOf { Dimensions() }
