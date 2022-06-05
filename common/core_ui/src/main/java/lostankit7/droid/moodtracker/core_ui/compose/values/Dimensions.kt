package lostankit7.droid.moodtracker.core_ui.compose.values

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Dimensions(
    val dp_0: Dp = 0.dp,
    val dp_2: Dp = 2.dp,
    val dp_4: Dp = 4.dp,
    val dp_6: Dp = 6.dp,
    val dp_8: Dp = 8.dp,
    val dp_10: Dp = 10.dp,
    val dp_12: Dp = 12.dp,
    val dp_16: Dp = 16.dp,
    val dp_18: Dp = 18.dp,
    val dp_20: Dp = 20.dp,
    val dp_30: Dp = 30.dp,
    val dp_35: Dp = 35.dp,
    val dp_50: Dp = 50.dp,
    val dp_65: Dp = 65.dp,
    val screenPadding: Dp = dp_10,
    val stdHeight: Dp = 45.dp,
    val defButtonHeight: Dp = 40.dp,
    val elevationLow: Dp = 1.dp,
    val elevation: Dp = 3.dp,
    val cornerRadius: Dp = 8.dp,
    val strokeLvl1: Dp = .7.dp,
    val strokeLvl2: Dp = dp_2,
    val text: Text = Text(),
    val userEntry: UserEntryDimens = UserEntryDimens(),
    val more: HomeMore = HomeMore(),
) {
    data class HomeMore(
        val profileImage: Dp = 75.dp,
    )

    data class UserEntryDimens(
        val moodIconSize: Dp = 45.dp,
        val optionMenuSize: Dp = 18.dp,
    )

    data class Text(
        val lvl1: TextUnit = 4.sp,
        val lvl2: TextUnit = 8.sp,
        val lvl3: TextUnit = 10.sp,
        val lvl4: TextUnit = 10.sp,
        val lvl5: TextUnit = 12.sp,
        val lvl6: TextUnit = 14.sp,
        val lvl7: TextUnit = 16.sp,
        val lvl8: TextUnit = 20.sp,
        val lvl9: TextUnit = 24.sp,
    )
}

val LocalSpacing = compositionLocalOf { Dimensions() }
