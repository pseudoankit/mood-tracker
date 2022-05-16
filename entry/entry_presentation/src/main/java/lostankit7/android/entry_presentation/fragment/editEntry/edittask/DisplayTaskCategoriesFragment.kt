package lostankit7.android.entry_presentation.fragment.editEntry.edittask

import android.view.LayoutInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.android.entry_domain.entities.Icon
import lostankit7.android.entry_domain.entities.TaskCategory
import lostankit7.android.entry_presentation.AddUserEntryActivity
import lostankit7.android.entry_presentation.R
import lostankit7.android.entry_presentation.adapter.IconListRvAdapter
import lostankit7.android.entry_presentation.databinding.DialogTextEntryBinding
import lostankit7.android.entry_presentation.databinding.FragmentDisplayListBinding
import lostankit7.android.entry_presentation.viewmodel.TaskEntryViewModel
import lostankit7.droid.moodtracker.core_presentation.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.core_presentation.utils.DialogHelper
import lostankit7.droid.moodtracker.core_presentation.utils.applyDefault

class DisplayTaskCategoriesFragment :
    BaseDaggerFragment<FragmentDisplayListBinding, TaskEntryViewModel>() {

    private val adapter = IconListRvAdapter(::categorySelected, ::rvOptionsSelected)

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.taskCategoriesLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun rvOptionsSelected(menuItem: MenuItem, item: Icon): Boolean {
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

    private fun categorySelected(item: Icon) {
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

    override fun updateActionBar() {
        (activity as? AddUserEntryActivity)?.actionBar?.apply {
            applyDefault()
        }
    }

    override fun injectFragment() {
        (activity as? AddUserEntryActivity)?.entryComponent?.inject(this)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentDisplayListBinding.inflate(layoutInflater)

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[TaskEntryViewModel::class.java]
}