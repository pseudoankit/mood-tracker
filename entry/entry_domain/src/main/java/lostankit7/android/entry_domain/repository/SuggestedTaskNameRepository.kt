package lostankit7.android.entry_domain.repository

import androidx.lifecycle.LiveData
import lostankit7.android.entry_domain.entities.SuggestedTaskName

interface SuggestedTaskNameRepository {

    val suggestedNames: LiveData<List<SuggestedTaskName>>
    suspend fun insertSuggestions(list: List<SuggestedTaskName>)
    suspend fun insertSuggestion(it: SuggestedTaskName)
    suspend fun deleteSuggestion(it: SuggestedTaskName)
}