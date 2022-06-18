package lostankit7.android.entry_data.mapper

import lostankit7.android.entry_data.local.entities.LocalSuggestedMoodIcon
import lostankit7.android.entry_domain.entities.SuggestedMoodIcon

object SuggestedMoodIconMapper {

    fun List<SuggestedMoodIcon>.toLocalSuggestedMoodIconInsert() =
        this.map { it.toLocalSuggestedMoodIconInsert() }

    fun SuggestedMoodIcon.toLocalSuggestedMoodIconInsert() = LocalSuggestedMoodIcon(icon, isSolid)

    fun List<LocalSuggestedMoodIcon>.toSuggestedMoodIcon() = this.map { it.toSuggestedMoodIcon() }

    fun LocalSuggestedMoodIcon.toSuggestedMoodIcon() =
        SuggestedMoodIcon(icon, isSolid).also { it.id = id }

}