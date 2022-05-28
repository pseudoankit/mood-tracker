package lostankit7.droid.moodtracker.home_more.presentation.home_more

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MoreViewModel @Inject constructor() : ViewModel() {
    var state by mutableStateOf(HomeMoreUIState())
        private set

    fun onEvent(event: HomeMoreEvent) {
        when (event) {
            is HomeMoreEvent.AlterProfileEditEnabledState -> {
                state = state.copy(profileEditEnabled = !state.profileEditEnabled)
            }
            is HomeMoreEvent.UpdateProfileName -> {
                state = state.copy(profileName = event.name)
            }
            is HomeMoreEvent.UpdateProfilePic -> {

            }
        }
    }
}