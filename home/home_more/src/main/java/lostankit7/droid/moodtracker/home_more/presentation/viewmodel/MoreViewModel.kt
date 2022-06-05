package lostankit7.droid.moodtracker.home_more.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import lostankit7.droid.moodtracker.home_more.R
import javax.inject.Inject

class MoreViewModel @Inject constructor() : ViewModel() {
    val state by mutableStateOf(State())


    data class State(
        val profilePic: MutableState<Int> = mutableStateOf(R.drawable.ic_me),
        val profileName: MutableState<String> = mutableStateOf(""),
        val profileEditEnabled: MutableState<Boolean> = mutableStateOf(false),
    )
}