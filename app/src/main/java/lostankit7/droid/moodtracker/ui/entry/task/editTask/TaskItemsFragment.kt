package lostankit7.droid.moodtracker.ui.entry.task.editTask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.MyApplication
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.databinding.FragmentShowListBinding
import lostankit7.droid.moodtracker.ui.adapter.IconListRvAdapter
import lostankit7.droid.moodtracker.ui.entry.task.TaskEntryViewModel

class TaskItemsFragment : BaseDaggerFragment<FragmentShowListBinding, TaskEntryViewModel>() {

    private var category: String? = null
    private val adapter by lazy {
        IconListRvAdapter.newInstance(::editTaskIcon, ::rvOptionsSelected)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun initListeners() {
        super.initListeners()

        binding.btnAddNew.setOnClickListener {

        }
    }

    private fun rvOptionsSelected(menuItem: MenuItem, item: Any): Boolean {
        return when (menuItem.itemId) {
            R.id.edit -> {
                editTaskIcon(item)
                true
            }
            R.id.delete -> {
                viewModel.deleteTask(item as TaskIcon)
                true
            }
            else -> false
        }
    }

    private fun editTaskIcon(item: Any) {
        navigateTo(
            R.id.action_taskItemsFragment_to_upsertTaskIconFragment,
            bundleOf(
                resources.getString(R.string.taskIcon_to_upsertTaskFrag) to item,
                resources.getString(R.string.category_to_upsertTaskFrag) to category
            )
        )
    }

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.getTaskIcons(category!!).observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun initRecyclerView() {
        super.initRecyclerView()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    override fun init() {
        super.init()
        category = arguments?.getString(resources.getString(R.string.arg_to_taskItemsFrag))
        if (category.isNullOrBlank()) navController.popBackStack()

    }

    override fun injectFragment() {
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentShowListBinding.inflate(layoutInflater)
}