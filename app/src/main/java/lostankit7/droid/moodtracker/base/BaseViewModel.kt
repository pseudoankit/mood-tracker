package lostankit7.droid.moodtracker.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import lostankit7.droid.moodtracker.model.Status

abstract class BaseViewModel : ViewModel() {

    protected val _uiStatus = MutableStateFlow<Status>(Status.Empty)
    val uiStatus: StateFlow<Status> = _uiStatus


    fun launchIo(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(Dispatchers.IO) { block() }
    }

}


