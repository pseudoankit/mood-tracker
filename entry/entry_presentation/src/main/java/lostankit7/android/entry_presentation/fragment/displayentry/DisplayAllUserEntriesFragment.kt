package lostankit7.android.entry_presentation.fragment.displayentry

class DisplayAllUserEntriesFragment : DisplayUserEntriesBaseFragment() {

    override suspend fun registerObservers() {
        super.registerObservers()

//        viewModel.allEntriesLiveData.observe(viewLifecycleOwner, {
//            adapter.submitList(it)
//        })
    }

}