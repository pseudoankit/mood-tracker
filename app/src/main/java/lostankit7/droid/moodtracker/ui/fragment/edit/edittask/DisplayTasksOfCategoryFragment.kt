package lostankit7.droid.moodtracker.ui.fragment.edit.edittask

import android.view.LayoutInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.databinding.FragmentDisplayListBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.ui.adapter.IconListRvAdapter
import lostankit7.droid.moodtracker.ui.viewmodel.TaskEntryViewModel

class DisplayTasksOfCategoryFragment : BaseDaggerFragment<FragmentDisplayListBinding, TaskEntryViewModel>() {

    private val args: DisplayTasksOfCategoryFragmentArgs by navArgs()
    private val adapter = IconListRvAdapter(::upsertTaskIcon, ::rvOptionsSelected)

    override fun initListeners() {
        super.initListeners()

        binding.button.setOnClickListener {
            upsertTaskIcon(null)
        }
    }

    private fun rvOptionsSelected(menuItem: MenuItem, item: Icon): Boolean {
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

    private fun upsertTaskIcon(item: Icon?) {

    }

    override suspend fun registerObservers() {
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

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentDisplayListBinding.inflate(layoutInflater)

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[TaskEntryViewModel::class.java]
}