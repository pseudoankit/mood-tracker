package lostankit7.droid.moodtracker.home_more.presentation.home_more.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.flow.collect
import lostankit7.droid.moodtracker.core_ui.utils.UIEvent
import lostankit7.droid.moodtracker.core_ui.utils.noRippleClickable
import lostankit7.droid.moodtracker.core_ui.utils.spacing
import lostankit7.droid.moodtracker.core_ui.utils.update
import lostankit7.droid.moodtracker.home_more.presentation.home_more.HomeMoreEvent
import lostankit7.droid.moodtracker.home_more.presentation.home_more.MoreViewModel

@ExperimentalComposeUiApi
@Composable
fun HomeMoreScreen(viewModel: MoreViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UIEvent.Keyboard -> {
                    keyboardController?.update(event.open)
                }
            }
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .noRippleClickable {
                viewModel.onEvent(HomeMoreEvent.ScreenTouched)
            }
    ) {
        DrawProfileSection(viewModel)
        Spacer(modifier = Modifier.height(spacing.dp_10))
    }

}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
}