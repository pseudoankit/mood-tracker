package lostankit7.android.entry_data.mapper

import lostankit7.android.entry_data.local.entities.LocalTaskCategory
import lostankit7.android.entry_domain.entities.TaskCategory

object TaskCategoryMapper {

    val List<LocalTaskCategory>.toTaskCategory get() = map { it.toTaskCategory }
    val List<TaskCategory>.toLocalTaskCategoryInsert get() = map { it.toLocalTaskCategoryInsert }
    val List<TaskCategory>.toLocalTaskCategoryUpdate get() = map { it.toLocalTaskCategoryUpdate }

    val LocalTaskCategory.toTaskCategory get() = TaskCategory(name).also { it.id = id }
    val TaskCategory.toLocalTaskCategoryInsert get() = LocalTaskCategory(name)
    val TaskCategory.toLocalTaskCategoryUpdate get() = LocalTaskCategory(name).also { it.id = id }
}