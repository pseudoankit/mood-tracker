package lostankit7.android.entry_data.mapper

import lostankit7.android.entry_data.local.entities.LocalSuggestedTaskName
import lostankit7.android.entry_domain.entities.SuggestedTaskName

object SuggestedTaskNameMapper {

    val List<SuggestedTaskName>.toLocalSuggestedTaskNameInsert get() = map { it.toLocalSuggestedTaskNameInsert }
    val List<LocalSuggestedTaskName>.toSuggestedTaskName get() = map { it.toSuggestedTaskName }

    val SuggestedTaskName.toLocalSuggestedTaskNameInsert get() = LocalSuggestedTaskName(name)
    val LocalSuggestedTaskName.toSuggestedTaskName get() = SuggestedTaskName(name)
}