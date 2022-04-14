package lostankit7.droid.moodtracker.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.fragment.BaseFragment
import lostankit7.droid.moodtracker.databinding.FragmentCalendarBinding
import lostankit7.droid.moodtracker.utils.formatDate

class CalendarFragment : BaseFragment<FragmentCalendarBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun initListeners() {
        super.initListeners()

        binding.calendar.setOnDateChangeListener { _, year, month, date ->
            onDateSelected(formatDate(date, month + 1, year))
        }
    }

    private fun onDateSelected(date: String) {
        navigateTo(
            R.id.action_calendarFragment_to_singleDateUserEntriesFragment,
            bundleOf(resources.getString(R.string.arg_date) to date)
        )
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentCalendarBinding.inflate(layoutInflater)

}