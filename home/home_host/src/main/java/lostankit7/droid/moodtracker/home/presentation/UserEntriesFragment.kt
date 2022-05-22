package lostankit7.droid.moodtracker.home.presentation

import android.view.LayoutInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import lostankit7.android.entry_presentation.R
import lostankit7.android.entry_presentation.viewmodel.UserEntriesViewModel
import lostankit7.droid.moodtracker.core.domain.entities.shared.UserEntry
import lostankit7.droid.moodtracker.core.presentation.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.core.presentation.shared.adapter.RvUserEntriesAdapter
import lostankit7.droid.moodtracker.home.databinding.FragmentUserEntriesBinding

class UserEntriesFragment : BaseDaggerFragment<FragmentUserEntriesBinding, UserEntriesViewModel>() {

    val adapter = RvUserEntriesAdapter(::onItemClicked)

    override fun initRecyclerView() {
        binding.rvUserEntries.adapter = adapter
    }

    private fun onItemClicked(menuItem: MenuItem, userEntry: UserEntry): Boolean {
        return when (menuItem.itemId) {
            R.id.edit -> {
                true
            }
            R.id.delete -> {
                viewModel.deleteUserEntry(userEntry)
                true
            }
            else -> false
        }
    }

    override fun registerObservers() {
        super.registerObservers()

//        viewModel.allEntriesLiveData.observe(viewLifecycleOwner) {
//            adapter.submitList(it)
//        }
    }

    override fun injectFragment() {

    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentUserEntriesBinding.inflate(layoutInflater)

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[UserEntriesViewModel::class.java]
}