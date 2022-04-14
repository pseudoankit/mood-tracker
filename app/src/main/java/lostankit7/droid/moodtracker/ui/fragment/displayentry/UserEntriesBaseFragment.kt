package lostankit7.droid.moodtracker.ui.fragment.displayentry

import android.view.LayoutInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import lostankit7.droid.moodtracker.databinding.FragmentUserEntriesBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.ui.adapter.RvUserEntriesAdapter
import lostankit7.droid.moodtracker.ui.viewmodel.UserEntriesViewModel

abstract class UserEntriesBaseFragment : BaseDaggerFragment<FragmentUserEntriesBinding, UserEntriesViewModel>() {

    val adapter by lazy { RvUserEntriesAdapter(::onItemClicked) }

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

    override fun init() {
        binding.rvUserEntries.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUserEntries.adapter = adapter
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentUserEntriesBinding.inflate(layoutInflater)

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[UserEntriesViewModel::class.java]
}