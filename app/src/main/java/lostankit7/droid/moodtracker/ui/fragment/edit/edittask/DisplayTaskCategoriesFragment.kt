package lostankit7.droid.moodtracker.ui.fragment.edit.edittask

import android.view.LayoutInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.databinding.DialogTextEntryBinding
import lostankit7.droid.moodtracker.databinding.FragmentDisplayListBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.ui.adapter.IconListRvAdapter
import lostankit7.droid.moodtracker.ui.viewmodel.TaskEntryViewModel
import lostankit7.droid.moodtracker.utils.DialogHelper

class DisplayTaskCategoriesFragment : BaseDaggerFragment<FragmentDisplayListBinding, TaskEntryViewModel>() {

    private val adapter = IconListRvAdapter(::categorySelected, ::rvOptionsSelected)

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.taskCategories.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun rvOptionsSelected(menuItem: MenuItem, item: Icon): Boolean {
        val _item = item as TaskCategory
        val oldText = _item.name
        return when (menuItem.itemId) {
            R.id.edit -> {
                showEdtDialog(oldText) { newText ->
                    _item.name = newText
                    viewModel.updateCategory(oldText, _item)
                }
                true
            }
            R.id.delete -> {
                viewModel.deleteCategory(_item)
                true
            }
            else -> false
        }
    }

    private fun categorySelected(item: Icon) {
        navigateTo(
            DisplayTaskCategoriesFragmentDirections.actionDisplayTaskCategoriesFragmentToDisplayTasksOfCategoryFragment(item.name)
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
                viewModel.addCategory(TaskCategory(it))
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

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentDisplayListBinding.inflate(layoutInflater)

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[TaskEntryViewModel::class.java]
}