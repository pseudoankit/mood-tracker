package lostankit7.android.entry_data.mapper

import lostankit7.android.entry_data.local.entities.LocalMoodIcon
import lostankit7.android.entry_domain.entities.MoodIcon

object MoodIconMapper {

    fun List<LocalMoodIcon>.toMoodIcon() = this.map { it.toMoodIcon() }
    fun LocalMoodIcon.toMoodIcon() = MoodIcon(icon, name, isSolid, id)

    fun List<MoodIcon>.toLocalMoodIconInsert() = this.map { it.toLocalMoodIconInsert() }
    fun MoodIcon.toLocalMoodIconInsert() = LocalMoodIcon(icon, name, isSolid)

    fun List<MoodIcon>.toLocalMoodIconUpdate() = this.map { it.toLocalMoodIconUpdate() }
    fun MoodIcon.toLocalMoodIconUpdate() = LocalMoodIcon(icon, name, isSolid).also { it.id = id }

}