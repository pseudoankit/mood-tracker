package lostankit7.droid.moodtracker.core_ui.compose.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import lostankit7.droid.moodtracker.core_ui.utils.spacing

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    value: String,
) {
    Card(
        modifier = modifier,
        elevation = spacing.elevationLow
    ) {
        Text(
            text = value,
            modifier = Modifier.padding(horizontal = spacing.dp_6, vertical = spacing.dp_4)
        )
    }
}