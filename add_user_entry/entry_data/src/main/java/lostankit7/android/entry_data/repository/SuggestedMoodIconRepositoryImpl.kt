package lostankit7.android.entry_data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import lostankit7.android.entry_data.local.dao.SuggestedMoodIconDao
import lostankit7.android.entry_data.mapper.SuggestedMoodIconMapper.toLocalSuggestedMoodIconInsert
import lostankit7.android.entry_data.mapper.SuggestedMoodIconMapper.toSuggestedMoodIcon
import lostankit7.android.entry_domain.entities.SuggestedMoodIcon
import lostankit7.android.entry_domain.repository.SuggestedMoodIconRepository

class SuggestedMoodIconRepositoryImpl(
    private val dao: SuggestedMoodIconDao,
) : SuggestedMoodIconRepository {

    override val suggestedMoodIcons: LiveData<List<SuggestedMoodIcon>> =
        dao.suggestedMoodIcons().map { it.toSuggestedMoodIcon() }

    override suspend fun insertSuggestedMoods(suggestedMoodIcons: List<SuggestedMoodIcon>) {
        dao.insertSuggestions(suggestedMoodIcons.toLocalSuggestedMoodIconInsert())
    }
}