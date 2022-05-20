package lostankit7.droid.moodtracker.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.ui.setupWithNavController
import lostankit7.droid.moodtracker.core.presentation.fragment.BaseFragment
import lostankit7.droid.moodtracker.core.presentation.utils.findNavHost
import lostankit7.droid.moodtracker.home.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavHost(binding.homeNavHostFragment.id)

        setUpBottomNavigation()
    }

    override fun initListeners() {

    }

    private fun setUpBottomNavigation() {
        with(binding.bottomNavView) {
            background = null
            menu.getItem(2).isEnabled = false
            setupWithNavController(navController)
        }
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentHomeBinding.inflate(layoutInflater)
}