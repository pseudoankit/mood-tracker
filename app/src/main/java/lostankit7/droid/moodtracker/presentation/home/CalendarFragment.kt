package lostankit7.droid.moodtracker.presentation.home

import android.view.LayoutInflater
import lostankit7.droid.moodtracker.core.presentation.utils.DateTimeUtils.formatDate
import lostankit7.droid.moodtracker.core.presentation.fragment.BaseFragment
import lostankit7.droid.moodtracker.databinding.FragmentCalendarBinding

class CalendarFragment : BaseFragment<FragmentCalendarBinding>() {

    override fun initListeners() {
        super.initListeners()

        binding.calendar.setOnDateChangeListener { _, year, month, date ->
            displayEntryOfDate(formatDate(date, month + 1, year))
        }
    }

    private fun displayEntryOfDate(date: String) {
//        navigateTo(
//            CalendarFragmentDirections.actionCalendarFragmentToDisplaySingleDateUserEntriesFragment(date)
//        )
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentCalendarBinding.inflate(layoutInflater)

}