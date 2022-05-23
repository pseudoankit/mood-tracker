package lostankit7.android.entry_domain.repository

import androidx.lifecycle.LiveData
import lostankit7.android.entry_domain.entities.SuggestedTaskIcon

interface SuggestedTaskIconRepository {
    val suggestedTaskIcon: LiveData<List<SuggestedTaskIcon>>
    suspend fun insertSuggestedTaskIcons(list: List<SuggestedTaskIcon>)
}