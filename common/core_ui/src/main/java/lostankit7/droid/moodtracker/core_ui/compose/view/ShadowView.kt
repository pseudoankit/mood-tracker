package lostankit7.droid.moodtracker.core_ui.compose.view

import androidx.annotation.IntDef
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import lostankit7.droid.moodtracker.core_ui.compose.view.ShadowDirection.Companion.BOTTOM
import lostankit7.droid.moodtracker.core_ui.compose.view.ShadowDirection.Companion.LEFT
import lostankit7.droid.moodtracker.core_ui.compose.view.ShadowDirection.Companion.RIGHT
import lostankit7.droid.moodtracker.core_ui.compose.view.ShadowDirection.Companion.TOP

@IntDef(TOP, BOTTOM, LEFT, RIGHT)
@Retention(AnnotationRetention.SOURCE)
annotation class ShadowDirection {
    companion object {
        const val BOTTOM = 1
        const val TOP = 2
        const val LEFT = 3
        const val RIGHT = 4
    }
}

@Composable
fun Shadow(
    modifier: Modifier = Modifier,
    alpha: Float = 0.1f,
    @ShadowDirection direction: Int,
) {

    val brush = createBrushOfDirection(alpha = alpha, direction = direction)

    Box(modifier = modifier
        .background(
            brush = brush
        )
    )
}

@Composable
private fun createBrushOfDirection(
    alpha: Float = 0.1f,
    @ShadowDirection direction: Int,
): Brush {
    return when (direction) {
        BOTTOM -> {
            Brush.verticalGradient(
                colors = listOf(
                    Color.Black.copy(alpha = alpha),
                    Color.Transparent,
                )
            )
        }
        LEFT -> {
            Brush.horizontalGradient(
                colors = listOf(
                    Color.Transparent,
                    Color.Black.copy(alpha = alpha),
                )
            )
        }
        RIGHT -> {
            Brush.horizontalGradient(
                colors = listOf(
                    Color.Black.copy(alpha = alpha),
                    Color.Transparent,
                )
            )
        }
        TOP -> {
            Brush.verticalGradient(
                colors = listOf(
                    Color.Transparent,
                    Color.Black.copy(alpha = alpha),
                )
            )
        }
        else -> throw IllegalArgumentException()
    }
}
