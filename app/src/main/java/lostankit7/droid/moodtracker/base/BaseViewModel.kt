package lostankit7.droid.moodtracker.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import lostankit7.droid.moodtracker.model.Status

abstract class BaseViewModel : ViewModel() {

    protected val _uiStatus = MutableStateFlow<Status>(Status.Empty)
    val uiStatus: StateFlow<Status> = _uiStatus




}


