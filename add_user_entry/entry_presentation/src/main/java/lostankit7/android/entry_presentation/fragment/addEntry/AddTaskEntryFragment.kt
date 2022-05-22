package lostankit7.android.entry_presentation.fragment.addEntry

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import lostankit7.android.entry_domain.entities.TaskIcon
import lostankit7.android.entry_presentation.adapter.RvTaskAdapter
import lostankit7.android.entry_presentation.adapter.TaskIconRvAdapter
import lostankit7.android.entry_presentation.databinding.FragmentAddTaskEntryBinding
import lostankit7.android.entry_presentation.utils.ActionBarUtils.showBackButtonWithIcon
import lostankit7.android.entry_presentation.utils.ActionBarUtils.showSaveButton
import lostankit7.android.entry_presentation.utils.ActionBarUtils.updateTitle
import lostankit7.android.entry_presentation.utils.Utils.entryComponent
import lostankit7.android.entry_presentation.utils.Utils.mActionBar
import lostankit7.android.entry_presentation.viewmodel.TaskEntryViewModel
import lostankit7.droid.moodtracker.core.domain.entities.shared.BaseIcon
import lostankit7.droid.moodtracker.core.presentation.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.core.presentation.utils.ViewExt.hideKeyBoard

class AddTaskEntryFragment : BaseDaggerFragment<FragmentAddTaskEntryBinding, TaskEntryViewModel>() {

    private val args: AddTaskEntryFragmentArgs by navArgs()
    private val adapter = RvTaskAdapter(::provideTaskIcons, ::onTaskSelected)

    private fun provideTaskIcons(category: String, adapter: TaskIconRvAdapter) {
        viewModel.getTaskIcons(category).observe(viewLifecycleOwner) {
            adapter.submitList(it)
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

    private fun onTaskSelected(task: BaseIcon) = with(viewModel){
        if (selectedTasksMap.containsKey(task.hashCode()))
            selectedTasksMap.remove(task.hashCode())
        else
            selectedTasksMap[task.hashCode()] = task as TaskIcon
    }

    override fun initRecyclerView() {
        super.initRecyclerView()
        binding.rvTask.adapter = adapter
    }

    fun saveEntry() {
        activity?.hideKeyBoard()
        viewModel.saveEntry(args.moodEntry, binding.etNote.text.toString())
        //todo navigate to homepage
    }

    override fun updateActionBar() {
        mActionBar?.apply {
            showBackButtonWithIcon(args.moodEntry.moodIcon.icon)
            updateTitle(args.moodEntry.moodIcon.name)
            showSaveButton()
        }
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentAddTaskEntryBinding.inflate(layoutInflater)

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[TaskEntryViewModel::class.java]

    override fun injectFragment() {
        activity?.entryComponent?.inject(this)
    }

}