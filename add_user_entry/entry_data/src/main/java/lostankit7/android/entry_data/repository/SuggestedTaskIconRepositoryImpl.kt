package lostankit7.android.entry_data.repository

import androidx.lifecycle.map
import lostankit7.android.entry_data.local.dao.SuggestedTaskIconDao
import lostankit7.android.entry_data.mapper.SuggestedTaskIconMapper.toLocalSuggestedTaskIconInsert
import lostankit7.android.entry_data.mapper.SuggestedTaskIconMapper.toSuggestedTaskIcon
import lostankit7.android.entry_domain.entities.SuggestedTaskIcon
import lostankit7.android.entry_domain.repository.SuggestedTaskIconRepository

class SuggestedTaskIconRepositoryImpl(
    private val dao: SuggestedTaskIconDao,
) : SuggestedTaskIconRepository {

    override val suggestedTaskIcon = dao.suggestedTaskIcons().map { it.toSuggestedTaskIcon() }

    override suspend fun insertSuggestedTaskIcons(list: List<SuggestedTaskIcon>) =
        dao.insertSuggestedIcons(list.toLocalSuggestedTaskIconInsert())
}