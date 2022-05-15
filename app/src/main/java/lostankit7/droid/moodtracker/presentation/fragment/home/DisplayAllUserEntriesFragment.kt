package lostankit7.droid.moodtracker.presentation.fragment.home

import lostankit7.droid.moodtracker.presentation.fragment.displayentry.DisplayUserEntriesBaseFragment

class DisplayAllUserEntriesFragment : DisplayUserEntriesBaseFragment() {

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.allEntriesLiveData.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

}