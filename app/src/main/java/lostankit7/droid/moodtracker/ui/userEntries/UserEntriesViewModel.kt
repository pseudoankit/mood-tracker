package lostankit7.droid.moodtracker.ui.userEntries

import androidx.lifecycle.ViewModel
import lostankit7.droid.moodtracker.base.BaseViewModel
import lostankit7.droid.moodtracker.data.repository.UserEntriesRepository
import javax.inject.Inject

class UserEntriesViewModel @Inject constructor(
    repository: UserEntriesRepository
) : BaseViewModel() {

    val userEntries = repository.userEntries
}