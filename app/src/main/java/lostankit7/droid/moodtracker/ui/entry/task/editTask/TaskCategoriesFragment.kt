package lostankit7.droid.moodtracker.ui.entry.task.editTask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.MyApplication
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.databinding.DialogTextEntryBinding
import lostankit7.droid.moodtracker.databinding.FragmentShowListBinding
import lostankit7.droid.moodtracker.helper.DialogHelper
import lostankit7.droid.moodtracker.ui.entry.task.TaskEntryViewModel
import lostankit7.droid.moodtracker.ui.entry.task.editTask.adapter.TaskCategoryRvAdapter

class TaskCategoriesFragment : BaseDaggerFragment<FragmentShowListBinding, TaskEntryViewModel>() {

    private val adapter by lazy { TaskCategoryRvAdapter.createInstance(::itemClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.taskCategories.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun itemClick(category: String) {
        navigateTo(
            R.id.action_taskCategoriesFragment_to_taskItemsFragment,
            bundleOf(resources.getString(R.string.arg_to_taskItemsFrag) to category)
        )
    }

    override fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    override fun initListeners() {
        super.initListeners()

        binding.btnAddNew.setOnClickListener {
            showDialog()
        }
    }

    override fun init() {
        super.init()
        binding.btnAddNew.text = resources.getString(R.string.text_add_new_category)
    }

    private fun showDialog() {
        DialogHelper.build(requireActivity(), DialogTextEntryBinding.inflate(layoutInflater))
        { view, dialog ->
            view.btnCancel.setOnClickListener { dialog.dismiss() }
            view.btnOkay.setOnClickListener {
                val text = view.edtText.text.toString().trim()
                if (text.isNotEmpty()) viewModel.addCategory(TaskCategory(text))
                dialog.dismiss()
            }
        }.show()
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentShowListBinding.inflate(layoutInflater)

    override fun injectFragment() {
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }
}