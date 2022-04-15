package lostankit7.droid.moodtracker.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.databinding.ActivityMainBinding
import lostankit7.droid.moodtracker.utils.ANIMATE_TOP_BOTTOM
import lostankit7.droid.moodtracker.utils.hide
import lostankit7.droid.moodtracker.utils.navOptions
import lostankit7.droid.moodtracker.utils.show


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.fragment_container)
        navController.addOnDestinationChangedListener(::onNavControllerDestinationChanged)

        initListener()
        setUpBottomNavigation()
    }

    private fun initListener() {
        binding.fabAddUserEntry.setOnClickListener { addEntryButtonClicked() }
    }

    private fun addEntryButtonClicked() {
        navController.navigate(R.id.addMoodEntryFragment)
    }

    private fun onNavControllerDestinationChanged(
        navController: NavController, destination: NavDestination, bundle: Bundle?,
    ) {
        when (destination.id) {
            R.id.calendarFragment , R.id.moreFragment , R.id.displayAllUserEntriesFragment -> {
                showBottomNav()
            }
            else -> hideBottomNav()
        }
    }

    private fun setUpBottomNavigation() {
        with(binding.bottomNavBar) {
            background = null
            menu.getItem(2).isEnabled = false
            setupWithNavController(navController)
        }
    }

    fun showBottomNav() {
        binding.bottomLayout.show()
        binding.fragmentBottomGuide.show()
    }

    fun hideBottomNav() {
        binding.bottomLayout.hide()
        binding.fragmentBottomGuide.hide()
    }
}