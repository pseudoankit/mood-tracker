package lostankit7.android.entry_presentation.fragment.addEntry

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import lostankit7.android.entry_domain.entities.MoodEntry
import lostankit7.android.entry_domain.entities.TaskIcon
import lostankit7.android.entry_presentation.R
import lostankit7.android.entry_presentation.adapter.RvTaskAdapter
import lostankit7.android.entry_presentation.adapter.TaskIconRvAdapter
import lostankit7.android.entry_presentation.databinding.FragmentAddTaskEntryBinding
import lostankit7.android.entry_presentation.di.EntryComponent.Companion.entryComponent
import lostankit7.android.entry_presentation.viewmodel.TaskEntryViewModel
import lostankit7.droid.moodtracker.core.domain.entities.shared.BaseIcon
import lostankit7.droid.moodtracker.core.presentation.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.core.presentation.utils.ViewExt.hideKeyBoard
import lostankit7.droid.moodtracker.core.presentation.utils.findRootNavHost

class AddTaskEntryFragment : BaseDaggerFragment<FragmentAddTaskEntryBinding, TaskEntryViewModel>() {

    private val args: AddTaskEntryFragmentArgs by navArgs()

    companion object {
        fun getMoodEntryFromBundle(args: Bundle?, context: Context): MoodEntry? {
            return args?.getParcelable(context.getString(R.string.arg_mood_entry_add_task_entry_frag))
        }
    }

    private val adapter = RvTaskAdapter(::provideTaskIcons, ::onTaskSelected)

    private fun provideTaskIcons(category: String, adapter: TaskIconRvAdapter) {
        viewModel.getTaskIcons(category).observe(viewLifecycleOwner) { list ->
            reSelectPreviousSelectedIcons(list)
            adapter.submitList(list)
        }
    }

    private fun reSelectPreviousSelectedIcons(list: List<TaskIcon>) {
        list.forEach { icon ->
            viewModel.selectedTasksMap[icon.id]?.let {
                icon.isSelected = true
            }
        }
    }

    override fun initListeners() {
        super.initListeners()

        binding.btnEditTask.setOnClickListener {
            navigateTo(
                AddTaskEntryFragmentDirections.actionAddTaskEntryFragmentToDisplayTaskCategoriesFragment()
            )
        }
    }

    override fun registerObservers() {
        super.registerObservers()

        viewModel.taskCategoriesLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun onTaskSelected(task: BaseIcon) = with(viewModel) {
        selectedTasksMap[task.id]?.let {
            selectedTasksMap.remove(task.id)
        } ?: run {
            selectedTasksMap[task.id] = task as TaskIcon
        }
    }

    override fun initRecyclerView() {
        super.initRecyclerView()
        binding.rvTask.adapter = adapter
    }

    fun saveEntry() {
        activity?.hideKeyBoard()
        viewModel.saveEntry(args.moodEntry, binding.etNote.text.toString())
        findRootNavHost?.popBackStack(R.id.addUserEntryHostFragment, true)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentAddTaskEntryBinding.inflate(layoutInflater)

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[TaskEntryViewModel::class.java]

    override fun injectFragment() {
        activity?.entryComponent?.inject(this)
    }

}