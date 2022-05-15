package lostankit7.droid.moodtracker.presentation.fragment.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.databinding.FragmentSplashBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.utils.constant.SplashFragmentDataProvider
import lostankit7.droid.moodtracker.presentation.viewmodel.SplashViewModel
const val SPLASH_TIME = 1500L
class SplashFragment : BaseDaggerFragment<FragmentSplashBinding, SplashViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.saveDefaultIcons(
            SplashFragmentDataProvider.moodIcons(requireContext()),
            SplashFragmentDataProvider.suggestedMoodIcons(),
            SplashFragmentDataProvider.taskCategories(requireContext()),
            SplashFragmentDataProvider.taskIcons(requireContext()),
            SplashFragmentDataProvider.suggestedTaskIcons(),
            SplashFragmentDataProvider.suggestedMoodNames(requireContext()),
            SplashFragmentDataProvider.suggestedTaskNames(requireContext())
        )

        lifecycleScope.launchWhenCreated {
            delay(SPLASH_TIME)
            navigateTo(
                SplashFragmentDirections.actionSplashFragmentToDisplayAllUserEntriesFragment()
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