package lostankit7.droid.moodtracker.core.presentation.utils

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//todo
object ViewModelUtils {
    fun CoroutineScope.launchIo(block: suspend CoroutineScope.() -> Unit) {
        launch(Dispatchers.IO) { block() }
    }
}