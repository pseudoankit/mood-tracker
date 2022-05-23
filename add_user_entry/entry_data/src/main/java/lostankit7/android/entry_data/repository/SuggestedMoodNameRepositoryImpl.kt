package lostankit7.android.entry_data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import lostankit7.android.entry_data.local.dao.SuggestedMoodNameDao
import lostankit7.android.entry_data.mapper.SuggestedMoodNameMapper.toLocalSuggestedMoodNameInsert
import lostankit7.android.entry_data.mapper.SuggestedMoodNameMapper.toSuggestedMoodName
import lostankit7.android.entry_domain.entities.SuggestedMoodName
import lostankit7.android.entry_domain.repository.SuggestedMoodNameRepository

class SuggestedMoodNameRepositoryImpl(private val dao: SuggestedMoodNameDao) :
    SuggestedMoodNameRepository {

    override val suggestedMoodNames: LiveData<List<SuggestedMoodName>> =
        dao.getSuggestions().map { it.toSuggestedMoodName() }

    override suspend fun insertSuggestions(list: List<SuggestedMoodName>) {
        dao.insertSuggestions(list.toLocalSuggestedMoodNameInsert())
    }

    override suspend fun insertSuggestion(it: SuggestedMoodName) {
        dao.insertSuggestion(it.toLocalSuggestedMoodNameInsert())
    }

    override suspend fun deleteSuggestion(it: SuggestedMoodName) {
        dao.deleteSuggestion(it.toLocalSuggestedMoodNameInsert())
    }

}