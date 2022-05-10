package lostankit7.droid.moodtracker.presentation.fragment.edit.editmood

import android.view.LayoutInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.databinding.FragmentDisplayListBinding
import lostankit7.droid.moodtracker.databinding.TaskEntryActionBarBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.presentation.adapter.IconListRvAdapter
import lostankit7.droid.moodtracker.presentation.viewmodel.MoodEntryViewModel
import lostankit7.droid.moodtracker.utils.showBackButton

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

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.moodIconsLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun updateActionBar(actionBar: TaskEntryActionBarBinding) = with(actionBar) {
        super.updateActionBar(actionBar)
        showBackButton()
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

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[MoodEntryViewModel::class.java]
}