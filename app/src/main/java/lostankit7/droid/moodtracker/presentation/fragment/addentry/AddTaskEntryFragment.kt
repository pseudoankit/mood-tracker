package lostankit7.droid.moodtracker.presentation.fragment.addentry

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.databinding.FragmentAddTaskEntryBinding
import lostankit7.droid.moodtracker.databinding.TaskEntryActionBarBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.presentation.adapter.RvTaskAdapter
import lostankit7.droid.moodtracker.presentation.adapter.TaskIconRvAdapter
import lostankit7.droid.moodtracker.presentation.viewmodel.TaskEntryViewModel
import lostankit7.droid.moodtracker.utils.hideKeyBoard
import lostankit7.droid.moodtracker.utils.show
import lostankit7.droid.moodtracker.utils.showBackAndSaveButton

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

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.taskCategoriesLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun onTaskSelected(task: Icon) = with(viewModel){
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
        navigateTo(
            AddTaskEntryFragmentDirections.actionAddTaskEntryFragmentToDisplayAllUserEntriesFragment()
        )
    }

    override fun updateActionBar(actionBar: TaskEntryActionBarBinding) = with(actionBar){
        super.updateActionBar(actionBar)
        showBackAndSaveButton()
        leftIcon1.text = resources.getString(R.string.fas_back)
        leftIcon2.apply {
            show()
            text = args.moodEntry.moodIcon.icon
        }
        title.text = args.moodEntry.moodIcon.name
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentAddTaskEntryBinding.inflate(layoutInflater)

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[TaskEntryViewModel::class.java]

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

}