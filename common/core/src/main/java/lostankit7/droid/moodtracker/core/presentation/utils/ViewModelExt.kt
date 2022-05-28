package lostankit7.droid.moodtracker.core.presentation.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun CoroutineScope.launchIo(block: suspend CoroutineScope.() -> Unit) {
    launch(Dispatchers.IO) { block() }
}