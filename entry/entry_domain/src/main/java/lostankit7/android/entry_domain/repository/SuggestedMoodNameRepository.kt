package lostankit7.android.entry_domain.repository

import kotlinx.coroutines.flow.Flow
import lostankit7.android.entry_domain.entities.SuggestedMoodName

interface SuggestedMoodNameRepository {
    val suggestedMoodNames: Flow<List<SuggestedMoodName>>
    suspend fun insertSuggestions(list: List<SuggestedMoodName>)
    suspend fun insertSuggestion(it: SuggestedMoodName)
    suspend fun deleteSuggestion(it: SuggestedMoodName)
}