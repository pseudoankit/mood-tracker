package lostankit7.droid.moodtracker.ui.entry.task.addTask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.MyApplication
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.databinding.FragmentTaskEntryBinding
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.model.MoodEntry
import lostankit7.droid.moodtracker.ui.entry.task.TaskEntryViewModel

class TaskEntryFragment : BaseDaggerFragment<FragmentTaskEntryBinding, TaskEntryViewModel>() {

    private lateinit var moodEntry: MoodEntry
    private val selectedTasksMap = mutableMapOf<Int, TaskIcon>()
    private val adapter by lazy {
        RvTaskAdapter.createInstance(::provideTaskIcons, ::onTaskSelected)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

    }

    private fun provideTaskIcons(category: String, adapter: RvTaskItemAdapter) {
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

    private fun onTaskSelected(task: TaskIcon) {
        if (selectedTasksMap.containsKey(task.hashCode()))
            selectedTasksMap.remove(task.hashCode())
        else
            selectedTasksMap[task.hashCode()] = task
    }

    private fun setUpRecyclerView() {
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
        hideKeyBoard()
        viewModel.saveEntry(moodEntry, selectedTasksMap, binding.etNote.text.toString())
        navigateTo(R.id.action_taskEntryFragment_to_entriesFragment)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentTaskEntryBinding.inflate(layoutInflater)

    override fun viewModel() = TaskEntryViewModel::class.java

    override fun injectFragment() {
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    companion object {
        const val taskSpan = 5
    }

}