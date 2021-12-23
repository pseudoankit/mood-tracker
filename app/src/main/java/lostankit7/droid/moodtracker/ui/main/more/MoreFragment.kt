package lostankit7.droid.moodtracker.ui.main.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import lostankit7.droid.moodtracker.base.BaseFragment
import lostankit7.droid.moodtracker.databinding.FragmentMoreBinding

class MoreFragment : BaseFragment<FragmentMoreBinding, MoreViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentMoreBinding.inflate(layoutInflater)

    override fun viewModel() = MoreViewModel::class.java
}