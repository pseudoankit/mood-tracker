package lostankit7.droid.moodtracker.home_more.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lazycoder21.droid.compose.FaIconType
import lostankit7.droid.moodtracker.home_more.R

@Composable
fun CircularFontAwesomeIcon(
    modifier: Modifier = Modifier,
    icon: FaIconType,
    size: Dp = 22.dp,
    tint: Color = Color.Unspecified,
    textStyle: TextStyle = TextStyle.Default,
    padding: Dp = 5.dp,
    strokeWidth: Dp = 1.dp,
    strokeColor: Color = Color(0xFFA39696),
    backgroundColor: Color = Color.Transparent,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: (() -> Unit)? = null,
) {

    val scaleFactor = LocalConfiguration.current.fontScale
    val fontSize = scaleIndependentFontSize(sizeInDp = size, scaleFactor = scaleFactor)

    val faTextStyle = textStyle.copy(
        color = tint,
        fontFamily = getFontFamily(icon),
        fontSize = fontSize
    )

    BasicText(
        text = icon.src.codePointToString(),
        modifier = modifier
            .wrapContentWidth()
            .clip(CircleShape)
            .border(
                width = strokeWidth,
                color = strokeColor,
                shape = CircleShape
            )
            .background(color = backgroundColor)
            .clickable(enabled, onClickLabel, role) { onClick?.invoke() }
            .padding(padding),
        style = faTextStyle,
    )
}

fun getFontFamily(faIconType: FaIconType): FontFamily {
    return when (faIconType) {
        is FaIconType.Brand -> FontFamily(
            Font(resId = R.font.fa_brands_400)
        )
        is FaIconType.Solid -> FontFamily(
            Font(resId = R.font.fa_solid_900)
        )
        is FaIconType.Regular -> FontFamily(
            Font(resId = R.font.fa_regular_400)
        )
    }
}

fun scaleIndependentFontSize(sizeInDp: Dp, scaleFactor: Float): TextUnit {
    val materialIconOffset = 3.dp
    return ((sizeInDp - materialIconOffset).value / scaleFactor).sp
}

fun Int.codePointToString() = this.toChar().toString()

