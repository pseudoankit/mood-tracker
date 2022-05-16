package lostankit7.droid.moodtracker.core.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    fun launchIo(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(Dispatchers.IO) { block() }
    }

}