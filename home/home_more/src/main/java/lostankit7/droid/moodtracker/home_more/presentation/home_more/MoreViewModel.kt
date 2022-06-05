package lostankit7.droid.moodtracker.home_more.presentation.home_more

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import lostankit7.droid.moodtracker.core.domain.preferences.Preferences
import lostankit7.droid.moodtracker.core.presentation.utils.launchIo
import lostankit7.droid.moodtracker.core_ui.utils.UIEvent
import javax.inject.Inject

class MoreViewModel @Inject constructor(
    private val prefs: Preferences,
) : ViewModel() {

    var state by mutableStateOf(HomeMoreUIState(profileName = prefs.profileName))
        private set

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: HomeMoreEvent) {
        when (event) {
            is HomeMoreEvent.AlterProfileEditEnabledState -> {
                state = state.copy(profileEditEnabled = !state.profileEditEnabled)
                onEvent(HomeMoreEvent.KeyboardState(state.profileEditEnabled))
                viewModelScope.launchIo {
                    prefs.profileName = state.profileName
                }
            }
            is HomeMoreEvent.UpdateProfileName -> {
                state = state.copy(profileName = event.name)
            }
            is HomeMoreEvent.UpdateProfilePic -> {

            }
            is HomeMoreEvent.ScreenTouched -> {
                if (state.profileEditEnabled)
                    onEvent(HomeMoreEvent.AlterProfileEditEnabledState)
            }
            is HomeMoreEvent.KeyboardState -> {
                viewModelScope.launch {
                    _uiEvent.send(UIEvent.Keyboard(open = event.open))
                }
            }
        }
    }
}