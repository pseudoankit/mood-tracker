package lostankit7.droid.moodtracker.ui.main.entry.task.addTask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.MyApplication
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.databinding.FragmentTaskEntryBinding
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.model.MoodEntry
import lostankit7.droid.moodtracker.ui.main.entry.task.TaskEntryViewModel

class TaskEntryFragment : BaseDaggerFragment<FragmentTaskEntryBinding, TaskEntryViewModel>() {

    private lateinit var moodEntry: MoodEntry
    private val selectedTasksMap = mutableMapOf<Int, MoodIcon>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        val adapter = RvTaskAdapter.createInstance(requireContext(), viewModel) { task ->
            if (selectedTasksMap.containsKey(task.hashCode()))
                selectedTasksMap.remove(task.hashCode())
            else
                selectedTasksMap[task.hashCode()] = task
        }
        binding.rvTask.adapter = adapter
    }

    override fun init() {
        val entry =
            arguments?.getParcelable<MoodEntry>(resources.getString(R.string.arg_to_addNewTaskFrag))
        if (entry == null) requireActivity().onBackPressed()
        else moodEntry = entry

        actionBar?.leftIcon2?.text = moodEntry.moodIcon.icon

        binding.rvTask.layoutManager = LinearLayoutManager(requireContext())

    }

    fun saveEntry() {
        hideKeyBoard()
        viewModel.saveEntry(moodEntry, selectedTasksMap, binding.etNote.text.toString())
        navigateTo(R.id.action_addTaskEntryFragment_to_entriesFragment)
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