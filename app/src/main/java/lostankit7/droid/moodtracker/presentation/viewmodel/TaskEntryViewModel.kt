package lostankit7.droid.moodtracker.presentation.viewmodel

import lostankit7.droid.moodtracker.base.viewmodel.BaseViewModel
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import lostankit7.droid.moodtracker.data.repository.*
import lostankit7.droid.moodtracker.domain.Mapper
import lostankit7.droid.moodtracker.presentation.fragment.splash.Constants.DB_ENTRY_SEPARATOR
import lostankit7.droid.moodtracker.model.MoodEntry
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