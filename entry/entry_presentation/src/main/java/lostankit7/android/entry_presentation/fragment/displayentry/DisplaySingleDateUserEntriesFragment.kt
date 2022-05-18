package lostankit7.android.entry_presentation.fragment.displayentry

import androidx.navigation.fragment.navArgs

class DisplaySingleDateUserEntriesFragment : DisplayUserEntriesBaseFragment() {

    private val args: DisplaySingleDateUserEntriesFragmentArgs by navArgs()

    override fun registerObservers() {
        super.registerObservers()

        viewModel.singleDateUserEntries(args.date).observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}