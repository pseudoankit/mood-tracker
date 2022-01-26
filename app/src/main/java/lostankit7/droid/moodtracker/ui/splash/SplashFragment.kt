package lostankit7.droid.moodtracker.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.databinding.FragmentSplashBinding
import lostankit7.droid.moodtracker.di.AppComponent

class SplashFragment : BaseDaggerFragment<FragmentSplashBinding, SplashViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.saveDefaultIcons(
            DefaultValues.moodIcons(requireContext()),
            DefaultValues.suggestedMoodIcons(),
            DefaultValues.taskCategories(requireContext()),
            DefaultValues.taskIcons(requireContext()),
            DefaultValues.suggestedTaskIcons(),
            DefaultValues.suggestedMoodNames(requireContext()),
            DefaultValues.suggestedTaskNames(requireContext())
        )

        lifecycleScope.launchWhenCreated {
            delay(1500)
            navigateTo(R.id.action_splashFragment_to_userEntriesFragment)
        }

    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentSplashBinding.inflate(layoutInflater)

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    companion object {

    }
}