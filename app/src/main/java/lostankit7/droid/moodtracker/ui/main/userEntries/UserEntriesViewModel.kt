package lostankit7.droid.moodtracker.ui.main.userEntries

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import lostankit7.droid.moodtracker.data.database.AppDatabase
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