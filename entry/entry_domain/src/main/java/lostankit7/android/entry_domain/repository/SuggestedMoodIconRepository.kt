package lostankit7.android.entry_domain.repository

import androidx.lifecycle.LiveData
import lostankit7.android.entry_domain.entities.SuggestedMoodIcon

interface SuggestedMoodIconRepository {
    val suggestedMoodIcons: LiveData<List<SuggestedMoodIcon>>
    suspend fun insertSuggestedMoods(suggestedMoodIcons: List<SuggestedMoodIcon>)
}