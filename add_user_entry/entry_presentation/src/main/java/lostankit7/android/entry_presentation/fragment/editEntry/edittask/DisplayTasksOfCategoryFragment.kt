package lostankit7.android.entry_presentation.fragment.editEntry.edittask

import android.view.LayoutInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.android.entry_domain.entities.TaskIcon
import lostankit7.android.entry_presentation.R
import lostankit7.android.entry_presentation.adapter.IconListRvAdapter
import lostankit7.android.entry_presentation.databinding.FragmentDisplayListBinding
import lostankit7.android.entry_presentation.utils.Utils.entryComponent
import lostankit7.android.entry_presentation.viewmodel.TaskEntryViewModel
import lostankit7.droid.moodtracker.core.domain.entities.shared.BaseIcon
import lostankit7.droid.moodtracker.core.presentation.base.fragment.BaseDaggerFragment

class DisplayTasksOfCategoryFragment :
    BaseDaggerFragment<FragmentDisplayListBinding, TaskEntryViewModel>() {

    private val args: DisplayTasksOfCategoryFragmentArgs by navArgs()
    private val adapter = IconListRvAdapter(::upsertTaskIcon, ::rvOptionsSelected)

    override fun initListeners() {
        super.initListeners()

        binding.button.setOnClickListener {
            upsertTaskIcon(null)
        }
    }

    private fun rvOptionsSelected(menuItem: MenuItem, item: BaseIcon): Boolean {
        return when (menuItem.itemId) {
            R.id.edit -> {
                upsertTaskIcon(item)
                true
            }
            R.id.delete -> {
                viewModel.deleteTask(item as TaskIcon)
                true
            }
            else -> false
        }
    }

    private fun upsertTaskIcon(item: BaseIcon?) {
        val _item = item as? TaskIcon
            navigateTo(
                DisplayTasksOfCategoryFragmentDirections.actionDisplayTasksOfCategoryFragmentToUpsertTaskIconFragment(
                    _item, args.categoryName
                )
            )
    }

    override fun registerObservers() {
        super.registerObservers()

        viewModel.getTaskIcons(args.categoryName).observe(viewLifecycleOwner) {
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
        binding.button.text = resources.getString(R.string.text_add_new_task)
    }

    override fun injectFragment() {
        activity?.entryComponent?.inject(this)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentDisplayListBinding.inflate(layoutInflater)

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[TaskEntryViewModel::class.java]
}