package lostankit7.android.entry_data.mapper

import lostankit7.android.entry_data.local.entities.LocalSuggestedMoodName
import lostankit7.android.entry_domain.entities.SuggestedMoodName

object SuggestedMoodNameMapper {

    fun List<SuggestedMoodName>.toLocalSuggestedMoodNameInsert() =
        map { it.toLocalSuggestedMoodNameInsert() }

    fun SuggestedMoodName.toLocalSuggestedMoodNameInsert() = LocalSuggestedMoodName(name)

    fun List<LocalSuggestedMoodName>.toSuggestedMoodName() = map { it.toSuggestedMoodName() }
    fun LocalSuggestedMoodName.toSuggestedMoodName() = SuggestedMoodName(name)
}