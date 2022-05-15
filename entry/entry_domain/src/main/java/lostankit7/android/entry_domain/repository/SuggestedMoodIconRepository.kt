package lostankit7.android.entry_domain.repository

import kotlinx.coroutines.flow.Flow
import lostankit7.android.entry_domain.entities.SuggestedMoodIcon

interface SuggestedMoodIconRepository {
    val suggestedMoodIcons: Flow<List<SuggestedMoodIcon>>
    suspend fun insertSuggestedMoods(suggestedMoodIcons: List<SuggestedMoodIcon>)
}