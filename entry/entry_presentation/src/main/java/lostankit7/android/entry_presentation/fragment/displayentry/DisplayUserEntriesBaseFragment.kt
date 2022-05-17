package lostankit7.android.entry_presentation.fragment.displayentry

import android.view.LayoutInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import lostankit7.android.entry_domain.entities.UserEntry
import lostankit7.android.entry_presentation.R
import lostankit7.android.entry_presentation.adapter.RvUserEntriesAdapter
import lostankit7.android.entry_presentation.databinding.FragmentDisplayUserEntriesBinding
import lostankit7.android.entry_presentation.utils.Utils.entryComponent
import lostankit7.android.entry_presentation.viewmodel.UserEntriesViewModel
import lostankit7.droid.moodtracker.core.presentation.fragment.BaseDaggerFragment
//todo check to use it
abstract class DisplayUserEntriesBaseFragment : BaseDaggerFragment<FragmentDisplayUserEntriesBinding, UserEntriesViewModel>() {

    protected val adapter = RvUserEntriesAdapter(::onItemClicked)

    override fun initRecyclerView() {
        binding.rvUserEntries.adapter = adapter
    }

    private fun onItemClicked(menuItem: MenuItem, userEntry: UserEntry): Boolean {
        return when (menuItem.itemId) {
            R.id.edit -> {
                //todo edit
                true
            }
            R.id.delete -> {
                viewModel.deleteUserEntry(userEntry)
                true
            }
            else -> false
        }
    }

    override fun injectFragment() {
        activity?.entryComponent?.inject(this)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentDisplayUserEntriesBinding.inflate(layoutInflater)

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[UserEntriesViewModel::class.java]
}