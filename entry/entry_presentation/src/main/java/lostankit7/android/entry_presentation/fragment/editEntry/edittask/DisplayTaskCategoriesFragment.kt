package lostankit7.android.entry_presentation.fragment.editEntry.edittask

import android.view.LayoutInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.core.domain.entities.BaseIcon
import lostankit7.android.entry_domain.entities.TaskCategory
import lostankit7.android.entry_presentation.R
import lostankit7.android.entry_presentation.adapter.IconListRvAdapter
import lostankit7.android.entry_presentation.databinding.DialogTextEntryBinding
import lostankit7.android.entry_presentation.databinding.FragmentDisplayListBinding
import lostankit7.android.entry_presentation.utils.Utils.entryComponent
import lostankit7.android.entry_presentation.viewmodel.TaskEntryViewModel
import lostankit7.droid.moodtracker.core.presentation.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.core.presentation.utils.DialogHelper

class DisplayTaskCategoriesFragment :
    BaseDaggerFragment<FragmentDisplayListBinding, TaskEntryViewModel>() {

    private val adapter = IconListRvAdapter(::categorySelected, ::rvOptionsSelected)

    override fun registerObservers() {
        super.registerObservers()

        viewModel.taskCategoriesLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun rvOptionsSelected(menuItem: MenuItem, item: BaseIcon): Boolean {
        val it = item as TaskCategory
        val oldText = it.name
        return when (menuItem.itemId) {
            R.id.edit -> {
                showEdtDialog(oldText) { newText ->
                    it.name = newText
                    viewModel.updateCategory(oldText, it)
                }
                true
            }
            R.id.delete -> {
                viewModel.deleteCategory(it)
                true
            }
            else -> false
        }
    }

    private fun categorySelected(item: BaseIcon) {
        navigateTo(
            DisplayTaskCategoriesFragmentDirections.actionDisplayTaskCategoriesFragmentToDisplayTasksOfCategoryFragment(
                item.name
            )
        )
    }

    override fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    override fun initListeners() {
        super.initListeners()

        binding.button.setOnClickListener {
            showEdtDialog {
                viewModel.addCategory(TaskCategory(
                    it))
            }
        }
    }

    override fun init() {
        super.init()
        binding.button.text = resources.getString(R.string.text_add_new_category)
    }

    private fun showEdtDialog(defValue: String = "", newText: (String) -> Unit) {
        DialogHelper.showDialog(requireActivity(), DialogTextEntryBinding.inflate(layoutInflater))
        { view, dialog ->
            view.edtText.setText(defValue)
            view.btnCancel.setOnClickListener { dialog.dismiss() }
            view.btnOkay.setOnClickListener {
                val text = view.edtText.text.toString().trim()
                if (text.isNotEmpty()) newText(text)
                dialog.dismiss()
            }
        }.show()
    }

    override fun injectFragment() {
        activity?.entryComponent?.inject(this)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentDisplayListBinding.inflate(layoutInflater)

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[TaskEntryViewModel::class.java]
}