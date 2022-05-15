package lostankit7.android.entry_data.repository

import kotlinx.coroutines.flow.map
import lostankit7.android.entry_data.local.dao.SuggestedTaskNameDao
import lostankit7.android.entry_data.mapper.SuggestedTaskNameMapper.toLocalSuggestedTaskNameInsert
import lostankit7.android.entry_data.mapper.SuggestedTaskNameMapper.toSuggestedTaskName
import lostankit7.android.entry_domain.entities.SuggestedTaskName
import lostankit7.android.entry_domain.repository.SuggestedTaskNameRepository

class SuggestedTaskNameRepositoryImpl(private val dao: SuggestedTaskNameDao) :
    SuggestedTaskNameRepository {

    override val suggestedNames = dao.getSuggestions().map { it.toSuggestedTaskName }

    override suspend fun insertSuggestions(list: List<SuggestedTaskName>) {
        dao.insertSuggestions(list.toLocalSuggestedTaskNameInsert)
    }

    override suspend fun insertSuggestion(it: SuggestedTaskName) {
        dao.insertSuggestion(it.toLocalSuggestedTaskNameInsert)
    }

    override suspend fun deleteSuggestion(it: SuggestedTaskName) =
        dao.deleteSuggestion(it.toLocalSuggestedTaskNameInsert)

}