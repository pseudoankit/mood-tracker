package lostankit7.android.entry_domain.repository

import kotlinx.coroutines.flow.Flow
import lostankit7.android.entry_domain.entities.SuggestedTaskName

interface SuggestedTaskNameRepository {

    val suggestedNames: Flow<List<SuggestedTaskName>>
    suspend fun insertSuggestions(list: List<SuggestedTaskName>)
    suspend fun insertSuggestion(it: SuggestedTaskName)
    suspend fun deleteSuggestion(it: SuggestedTaskName)
}