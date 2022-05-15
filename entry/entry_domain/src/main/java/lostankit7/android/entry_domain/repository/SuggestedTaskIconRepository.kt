package lostankit7.android.entry_domain.repository

import kotlinx.coroutines.flow.Flow
import lostankit7.android.entry_domain.entities.SuggestedTaskIcon

interface SuggestedTaskIconRepository {
    val suggestedTaskIcon: Flow<List<SuggestedTaskIcon>>
    suspend fun insertSuggestedTaskIcons(list: List<SuggestedTaskIcon>)
}