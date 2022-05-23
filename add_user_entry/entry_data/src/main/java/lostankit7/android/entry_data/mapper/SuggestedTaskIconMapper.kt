package lostankit7.android.entry_data.mapper

import lostankit7.android.entry_data.local.entities.LocalSuggestedTaskIcon
import lostankit7.android.entry_domain.entities.SuggestedTaskIcon

object SuggestedTaskIconMapper {

    fun List<SuggestedTaskIcon>.toLocalSuggestedTaskIconInsert() =
        this.map { it.toLocalSuggestedTaskIconInsert() }

    fun SuggestedTaskIcon.toLocalSuggestedTaskIconInsert() =
        LocalSuggestedTaskIcon(icon, name, isSolid)

    fun List<LocalSuggestedTaskIcon>.toSuggestedTaskIcon() =
        this.map { it.toSuggestedTaskIcon() }

    fun LocalSuggestedTaskIcon.toSuggestedTaskIcon() =
        SuggestedTaskIcon(icon, name, isSolid).also { it.id = id }
}