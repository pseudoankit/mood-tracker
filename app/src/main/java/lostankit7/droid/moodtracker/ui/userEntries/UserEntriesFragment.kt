package lostankit7.droid.moodtracker.ui.userEntries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.MyApplication
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import lostankit7.droid.moodtracker.databinding.FragmentUserEntriesBinding
import lostankit7.droid.moodtracker.di.AppComponent

class UserEntriesFragment : BaseDaggerFragment<FragmentUserEntriesBinding, UserEntriesViewModel>() {

    private val mAdapter by lazy { RvUserEntriesAdapter(::onItemClicked) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun onItemClicked(userEntry: UserEntry) {

    }

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.userEntries.observe(viewLifecycleOwner, {
            mAdapter.submitList(it)
        })
    }

    override fun init() {
        binding.rvUserEntries.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUserEntries.adapter = mAdapter
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentUserEntriesBinding.inflate(layoutInflater)

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }
}