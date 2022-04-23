package lostankit7.droid.moodtracker.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ui.NavigationUI
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.fragment.BaseFragment
import lostankit7.droid.moodtracker.databinding.FragmentHomeBottomNavigationBinding

class HomeBottomNavigationFragment : BaseFragment<FragmentHomeBottomNavigationBinding>() {

    override fun init() {
        super.init()

        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() {
        binding.bottomNavBar.apply {
            background = null
            menu.getItem(2).isEnabled = false
            NavigationUI.setupWithNavController(this, navController)
        }
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentHomeBottomNavigationBinding.inflate(layoutInflater)
}