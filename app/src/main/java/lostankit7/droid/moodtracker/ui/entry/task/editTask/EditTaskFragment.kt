package lostankit7.droid.moodtracker.ui.entry.task.editTask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.MyApplication
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.databinding.DialogTextEntryBinding
import lostankit7.droid.moodtracker.databinding.FragmentEditBinding
import lostankit7.droid.moodtracker.databinding.ItemRvSingleTextBinding
import lostankit7.droid.moodtracker.helper.Dialog
import lostankit7.droid.moodtracker.ui.entry.task.TaskEntryViewModel

class EditTaskFragment : BaseDaggerFragment<FragmentEditBinding, TaskEntryViewModel>() {

    private lateinit var adapter: BaseDiffRvAdapter<ItemRvSingleTextBinding, TaskCategory>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.taskCategories.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = object : BaseDiffRvAdapter<ItemRvSingleTextBinding, TaskCategory>() {
            override fun bindViewHolder(
                item: TaskCategory, position: Int, binding: ItemRvSingleTextBinding
            ) {
                binding.tvText.text = item.category
            }

            override fun inflateLayout(
                layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
            ) = ItemRvSingleTextBinding.inflate(layoutInflater, parent, attachToParent)
        }
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
        Dialog.build(requireActivity(), DialogTextEntryBinding.inflate(layoutInflater))
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
        FragmentEditBinding.inflate(layoutInflater)

    override fun viewModel() = TaskEntryViewModel::class.java
    override fun injectFragment() {
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }
}