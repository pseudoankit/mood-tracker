package lostankit7.android.entry_data.mapper

import lostankit7.android.entry_data.local.entities.LocalTaskIcon
import lostankit7.android.entry_domain.entities.TaskIcon


object TaskIconMapper {

    val List<LocalTaskIcon>.toTaskIcon get() = map { it.toTaskIcon }
    val List<TaskIcon>.toLocalTaskIconInsert get() = map { it.toLocalTaskIconInsert }
    val List<TaskIcon>.toLocalTaskIconUpdate get() = map { it.toLocalTaskIconUpdate }

    val LocalTaskIcon.toTaskIcon get() = TaskIcon(icon, name, category, isSolid, id)
    val TaskIcon.toLocalTaskIconInsert get() = LocalTaskIcon(icon, name, category, isSolid)
    val TaskIcon.toLocalTaskIconUpdate
        get() = LocalTaskIcon(icon, name, category, isSolid).also { it.id = id }

}