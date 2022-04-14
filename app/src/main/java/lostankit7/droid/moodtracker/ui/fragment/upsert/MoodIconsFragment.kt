package lostankit7.droid.moodtracker.ui.fragment.upsert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.databinding.FragmentShowListBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.ui.viewmodel.MoodEntryViewModel
import lostankit7.droid.moodtracker.ui.adapter.IconListRvAdapter

class MoodIconsFragment : BaseDaggerFragment<FragmentShowListBinding, MoodEntryViewModel>() {

    private val adapter by lazy {
        IconListRvAdapter.newInstance(::editMoodIcon, ::rvOptionsSelected)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun editMoodIcon(item: Icon) {
        navigateTo(
            R.id.action_editMoodFragment_to_upsertMoodIconFragment,
            bundleOf(resources.getString(R.string.arg_to_upsertMoodFrag) to item)
        )
    }

    private fun rvOptionsSelected(menuItem: MenuItem, item: Icon): Boolean {
        return when (menuItem.itemId) {
            R.id.edit -> {
                editMoodIcon(item)
                true
            }
            R.id.delete -> {
                viewModel.deleteMoodIcon(item as MoodIcon)
                true
            }
            else -> false
        }
    }

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.moodIcons.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun initListeners() {
        binding.btnAddNew.setOnClickListener {
            navigateTo(R.id.action_editMoodFragment_to_upsertMoodIconFragment)
        }
    }

    override fun initRecyclerView() {
        super.initRecyclerView()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentShowListBinding.inflate(layoutInflater)

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[MoodEntryViewModel::class.java]
}