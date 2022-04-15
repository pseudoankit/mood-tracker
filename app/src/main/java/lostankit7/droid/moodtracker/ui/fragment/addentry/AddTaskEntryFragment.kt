package lostankit7.droid.moodtracker.ui.fragment.addentry

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.databinding.FragmentAddTaskEntryBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.ui.adapter.RvTaskAdapter
import lostankit7.droid.moodtracker.ui.adapter.TaskIconRvAdapter
import lostankit7.droid.moodtracker.ui.viewmodel.TaskEntryViewModel
import lostankit7.droid.moodtracker.utils.hideKeyBoard

class AddTaskEntryFragment : BaseDaggerFragment<FragmentAddTaskEntryBinding, TaskEntryViewModel>() {

    private val args: AddTaskEntryFragmentArgs by navArgs()
    private val selectedTasksMap = mutableMapOf<Int, TaskIcon>()
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

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.taskCategories.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun onTaskSelected(task: Icon) {
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
        requireActivity().hideKeyBoard()
        viewModel.saveEntry(args.moodEntry, selectedTasksMap, binding.etNote.text.toString())

    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentAddTaskEntryBinding.inflate(layoutInflater)


    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[TaskEntryViewModel::class.java]

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

}