package lostankit7.droid.moodtracker.ui.userEntries

import androidx.lifecycle.ViewModel
import lostankit7.droid.moodtracker.data.repository.UserEntriesRepository
import javax.inject.Inject

class UserEntriesViewModel @Inject constructor(
    repository: UserEntriesRepository
) : ViewModel() {

    /*init {
        val dao = AppDatabase.getDatabase(application,viewModelScope).userEntryDao()
        repository = UserEntriesRepository(dao)
    }*/

    val userEntries = repository.userEntries
}