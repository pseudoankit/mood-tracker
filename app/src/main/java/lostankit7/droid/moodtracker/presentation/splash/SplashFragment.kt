package lostankit7.droid.moodtracker.presentation.splash

import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.core.presentation.base.fragment.BaseFragment
import lostankit7.droid.moodtracker.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    companion object {
        private const val SPLASH_TIME = 1500L
    }

    override fun init() {
        navController.popBackStack()

        lifecycleScope.launchWhenCreated {
            delay(SPLASH_TIME)
            navigateAfterSplash()
        }
    }

    private fun navigateAfterSplash() {
        navController.navigate(R.id.nav_graph_home_host)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentSplashBinding.inflate(layoutInflater)
}