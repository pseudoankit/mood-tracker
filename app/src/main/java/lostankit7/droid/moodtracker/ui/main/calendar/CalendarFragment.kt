package lostankit7.droid.moodtracker.ui.main.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import lostankit7.droid.moodtracker.base.BaseFragment
import lostankit7.droid.moodtracker.databinding.FragmentCalendarBinding

class CalendarFragment : BaseFragment<FragmentCalendarBinding, CalendarViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentCalendarBinding.inflate(layoutInflater)

    override fun viewModel() = CalendarViewModel::class.java

}