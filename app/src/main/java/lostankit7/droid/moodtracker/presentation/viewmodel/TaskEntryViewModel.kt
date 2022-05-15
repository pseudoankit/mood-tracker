package lostankit7.droid.moodtracker.presentation.viewmodel

import lostankit7.droid.moodtracker.core_presentation.viewmodel.BaseViewModel
import lostankit7.android.entry_data.database.entities.TaskCategory
import lostankit7.android.entry_data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.data.repository.*
import lostankit7.droid.moodtracker.domain.Mapper
import lostankit7.droid.moodtracker.model.MoodEntry
import javax.inject.Inject

class TaskEntryViewModel @Inject constructor(
    private val repository: lostankit7.android.entry_data.repository.UserEntriesRepository,
    private val taskCategoryRepo: lostankit7.android.entry_data.repository.TaskCategoryRepository,
    private val taskIconRepo: lostankit7.android.entry_data.repository.TaskIconRepository,
    private val suggestedTaskRepo: lostankit7.android.entry_data.repository.SuggestedTaskIconRepository,
    private val suggestedTaskNameRepository: lostankit7.android.entry_data.repository.SuggestedTaskNameRepository,
) : BaseViewModel() {

    val selectedTasksMap = mutableMapOf<Int, lostankit7.android.entry_data.database.entities.TaskIcon>()

    val suggestedTaskNamesLiveData get() = suggestedTaskNameRepository.suggestedNames
    val suggestedTaskIconsLiveData get() = suggestedTaskRepo.suggestedTaskIcon
    val taskCategoriesLiveData get() = taskCategoryRepo.taskCategories

    fun addCategory(item: lostankit7.android.entry_data.database.entities.TaskCategory) = launchIo { taskCategoryRepo.insertTaskCategory(item) }
    fun deleteCategory(it: lostankit7.android.entry_data.database.entities.TaskCategory) = launchIo { taskCategoryRepo.deleteTaskCategory(it) }
    fun updateCategory(oldText: String, new: lostankit7.android.entry_data.database.entities.TaskCategory) {
        launchIo { taskCategoryRepo.updateCategory(new) }
        launchIo { taskIconRepo.updateTaskCategory(oldText, new.name) }
    }

    fun getTaskIcons(category: String) = taskIconRepo.getTaskIcons(category)
    fun insertTask(it: lostankit7.android.entry_data.database.entities.TaskIcon) = launchIo { taskIconRepo.insertTask(it) }
    fun updateTask(it: lostankit7.android.entry_data.database.entities.TaskIcon) = launchIo { taskIconRepo.updateTask(it) }
    fun deleteTask(it: lostankit7.android.entry_data.database.entities.TaskIcon) = launchIo { taskIconRepo.deleteTask(it) }

    fun saveEntry(moodEntry: MoodEntry, note: String) = launchIo {
        repository.saveUserEntry(Mapper.mapDataToUserEntry(moodEntry, selectedTasksMap, note))
    }
}