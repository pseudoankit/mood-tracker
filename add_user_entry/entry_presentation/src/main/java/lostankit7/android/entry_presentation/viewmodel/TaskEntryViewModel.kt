package lostankit7.android.entry_presentation.viewmodel

import lostankit7.android.entry_domain.entities.MoodEntry
import lostankit7.android.entry_domain.entities.TaskCategory
import lostankit7.android.entry_domain.entities.TaskIcon
import lostankit7.android.entry_domain.mapper.Mapper
import lostankit7.android.entry_domain.repository.*
import lostankit7.droid.moodtracker.core.presentation.base.viewmodel.BaseViewModel
import javax.inject.Inject

class TaskEntryViewModel @Inject constructor(
    private val repository: UserEntriesRepository,
    private val taskCategoryRepo: TaskCategoryRepository,
    private val taskIconRepo: TaskIconRepository,
    private val suggestedTaskRepo: SuggestedTaskIconRepository,
    private val suggestedTaskNameRepository: SuggestedTaskNameRepository,
) : BaseViewModel() {

    val selectedTasksMap = mutableMapOf<Int, TaskIcon>()

    val suggestedTaskNamesLiveData get() = suggestedTaskNameRepository.suggestedNames
    val suggestedTaskIconsLiveData get() = suggestedTaskRepo.suggestedTaskIcon
    val taskCategoriesLiveData get() = taskCategoryRepo.taskCategories

    fun addCategory(item: TaskCategory) = launchIo { taskCategoryRepo.insertTaskCategory(item) }
    fun deleteCategory(it: TaskCategory) = launchIo { taskCategoryRepo.deleteTaskCategory(it) }
    fun updateCategory(oldText: String, new: TaskCategory) {
        launchIo { taskCategoryRepo.updateCategory(new) }
        launchIo { taskIconRepo.updateTaskCategory(oldText, new.name) }
    }

    fun getTaskIcons(category: String) = taskIconRepo.getTaskIcons(category)
    fun insertTask(it: TaskIcon) = launchIo { taskIconRepo.insertTask(it) }
    fun updateTask(it: TaskIcon) = launchIo { taskIconRepo.updateTask(it) }
    fun deleteTask(it: TaskIcon) = launchIo { taskIconRepo.deleteTask(it) }

    fun saveEntry(moodEntry: MoodEntry, note: String) = launchIo {
        repository.saveUserEntry(Mapper.mapDataToUserEntry(moodEntry, selectedTasksMap, note))
    }
}