package lostankit7.droid.moodtracker.ui.fragment.addentry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.databinding.FragmentTaskEntryBinding
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.utils.hideKeyBoard
import lostankit7.droid.moodtracker.model.MoodEntry
import lostankit7.droid.moodtracker.ui.adapter.TaskIconRvAdapter
import lostankit7.droid.moodtracker.ui.adapter.RvTaskAdapter
import lostankit7.droid.moodtracker.ui.viewmodel.TaskEntryViewModel

class AddTaskEntryFragment : BaseDaggerFragment<FragmentTaskEntryBinding, TaskEntryViewModel>() {

    private lateinit var moodEntry: MoodEntry
    private val selectedTasksMap = mutableMapOf<Int, TaskIcon>()
    private val adapter by lazy {
        RvTaskAdapter.createInstance(::provideTaskIcons, ::onTaskSelected)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //todo list always getting refreshed

    }

    private fun provideTaskIcons(category: String, adapter: TaskIconRvAdapter) {
        viewModel.getTaskIcons(category).observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun initListeners() {
        super.initListeners()

        binding.btnEditTask.setOnClickListener {
            navigateTo(R.id.action_taskEntryFragment_to_editTaskFragment)
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
        binding.rvTask.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTask.adapter = adapter
    }

    override fun init() {
        val entry =
            arguments?.getParcelable<MoodEntry>(resources.getString(R.string.arg_to_addNewTaskFrag))
        if (entry == null) requireActivity().onBackPressed()
        else moodEntry = entry

        actionBar?.leftIcon2?.text = moodEntry.moodIcon.icon
    }

    fun saveEntry() {
        requireActivity().hideKeyBoard()
        viewModel.saveEntry(moodEntry, selectedTasksMap, binding.etNote.text.toString())
        navigateTo(R.id.action_taskEntryFragment_to_allUserEntriesFragment)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentTaskEntryBinding.inflate(layoutInflater)


    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    companion object {
        const val taskSpan = 5
    }

}