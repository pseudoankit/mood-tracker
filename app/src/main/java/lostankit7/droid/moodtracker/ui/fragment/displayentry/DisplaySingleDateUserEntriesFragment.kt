package lostankit7.droid.moodtracker.ui.fragment.displayentry

import androidx.navigation.fragment.navArgs

class DisplaySingleDateUserEntriesFragment : DisplayUserEntriesBaseFragment() {

    private val args: DisplaySingleDateUserEntriesFragmentArgs by navArgs()

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.singleDateUserEntries(args.date).observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }
}