package lostankit7.droid.moodtracker.ui.fragment.displayentry

import lostankit7.droid.moodtracker.R

class SingleDateUserEntriesFragment : UserEntriesBaseFragment() {

    private var date: String? = null

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.userEntries(date!!).observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    override fun onResume() {
        super.onResume()
        actionBar?.tvTitle?.text = date
    }

    override fun onPause() {
        super.onPause()
        actionBar?.tvTitle?.text = ""
    }

    override fun init() {
        super.init()
        date = arguments?.getString(resources.getString(R.string.arg_date))
        if (date == null) navController.popBackStack()
        mActivity?.hideBottomNav()
        mActivity?.showActionBar()
    }
}