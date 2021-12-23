package lostankit7.droid.moodtracker.ui.main.customizeIcon.mood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.base.BaseFragment
import lostankit7.droid.moodtracker.databinding.FragmentEditMoodBinding

class EditMoodFragment : BaseFragment<FragmentEditMoodBinding, EditMoodViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentEditMoodBinding.inflate(layoutInflater)
    override fun viewModel() = EditMoodViewModel::class.java

}