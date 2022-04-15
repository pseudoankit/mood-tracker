package lostankit7.droid.moodtracker.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.databinding.FragmentSplashBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.ui.viewmodel.MoodEntryViewModel
import lostankit7.droid.moodtracker.utils.constant.SplashFragmentDefaultValues
import lostankit7.droid.moodtracker.ui.viewmodel.SplashViewModel
import lostankit7.droid.moodtracker.utils.constant.Constants

class SplashFragment : BaseDaggerFragment<FragmentSplashBinding, SplashViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.saveDefaultIcons(
            SplashFragmentDefaultValues.moodIcons(requireContext()),
            SplashFragmentDefaultValues.suggestedMoodIcons(),
            SplashFragmentDefaultValues.taskCategories(requireContext()),
            SplashFragmentDefaultValues.taskIcons(requireContext()),
            SplashFragmentDefaultValues.suggestedTaskIcons(),
            SplashFragmentDefaultValues.suggestedMoodNames(requireContext()),
            SplashFragmentDefaultValues.suggestedTaskNames(requireContext())
        )

        lifecycleScope.launchWhenCreated {
            delay(Constants.SPLASH_TIME)
            navigateTo(
                SplashFragmentDirections.actionSplashFragmentToHomeBottomNavigationFragment()
            )
        }

    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentSplashBinding.inflate(layoutInflater)

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[SplashViewModel::class.java]
}