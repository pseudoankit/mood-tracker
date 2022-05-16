package lostankit7.droid.moodtracker.presentation.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.delay
import lostankit7.android.entry_presentation.utils.SplashFragmentDataProvider
import lostankit7.droid.moodtracker.core.utils.Constants
import lostankit7.droid.moodtracker.core_presentation.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.databinding.FragmentSplashBinding
import lostankit7.droid.moodtracker.di.component.DaggerAppComponent

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
            delay(Constants.SPLASH_TIME)
            navigateTo(
                SplashFragmentDirections.actionSplashFragmentToDisplayAllUserEntriesFragment()
            )
        }

    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentSplashBinding.inflate(layoutInflater)

    override fun injectFragment() {
        DaggerAppComponent.factory().create(requireContext().applicationContext).inject(this)
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[SplashViewModel::class.java]
}