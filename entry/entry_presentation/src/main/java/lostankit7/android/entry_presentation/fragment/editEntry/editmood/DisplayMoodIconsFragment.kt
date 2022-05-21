package lostankit7.android.entry_presentation.fragment.editEntry.editmood

import android.view.LayoutInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import lostankit7.android.entry_domain.entities.Icon
import lostankit7.android.entry_domain.entities.MoodIcon
import lostankit7.android.entry_presentation.R
import lostankit7.android.entry_presentation.adapter.IconListRvAdapter
import lostankit7.android.entry_presentation.databinding.FragmentDisplayListBinding
import lostankit7.android.entry_presentation.utils.Utils.entryComponent
import lostankit7.android.entry_presentation.viewmodel.MoodEntryViewModel
import lostankit7.droid.moodtracker.core.presentation.fragment.BaseDaggerFragment

class DisplayMoodIconsFragment :
    BaseDaggerFragment<FragmentDisplayListBinding, MoodEntryViewModel>() {

    private val adapter = IconListRvAdapter(::upsertMoodIcon, ::rvOptionsSelected)

    private fun rvOptionsSelected(menuItem: MenuItem, item: Icon): Boolean {
        return when (menuItem.itemId) {
            R.id.edit -> {
                upsertMoodIcon(item)
                true
            }
            R.id.delete -> {
                viewModel.deleteMoodIcon(item as MoodIcon)
                true
            }
            else -> false
        }
    }

    private fun upsertMoodIcon(item: Icon?) {
        navigateTo(
            DisplayMoodIconsFragmentDirections.actionDisplayMoodIconsFragmentToUpsertMoodIconFragment(
                item as? MoodIcon
            )
        )
    }

    override fun registerObservers() {
        super.registerObservers()

        viewModel.moodIconsLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun initListeners() {
        binding.button.setOnClickListener {
            upsertMoodIcon(null)
        }
    }

    override fun initRecyclerView() {
        super.initRecyclerView()
        binding.recyclerView.adapter = adapter
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentDisplayListBinding.inflate(layoutInflater)

    override fun injectFragment() {
        activity?.entryComponent?.inject(this)
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[MoodEntryViewModel::class.java]
}