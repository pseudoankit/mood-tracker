package lostankit7.droid.moodtracker.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import lostankit7.droid.helper.hide
import lostankit7.droid.helper.show
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.fragment_container)
        navController.addOnDestinationChangedListener(::onNavControllerDestinationChanged)

        setUpBottomNavigation()
        binding.fabAddUserEntry.setOnClickListener { addEntryButtonClicked() }
    }

    private fun addEntryButtonClicked() {
        val navBuilder = NavOptions.Builder()
        navBuilder.setEnterAnim(R.anim.anim_bottom_to_top)
            .setPopExitAnim(R.anim.anim_top_to_bottom)

        navController.navigate(R.id.addMoodEntryFragment, null, navBuilder.build())
    }

    private fun onNavControllerDestinationChanged(
        navController: NavController,
        destination: NavDestination,
        bundle: Bundle?
    ) {
        when (destination.id) {
            R.id.userEntriesFragment -> showBottomNav()
            R.id.calendarFragment -> showBottomNav()
            R.id.moreFragment -> showBottomNav()
            else -> hideBottomNav()
        }
    }

    private fun setUpBottomNavigation() {
        with(binding.bottomNavBar) {
            background = null
            menu.getItem(2).isEnabled = false
            NavigationUI.setupWithNavController(this, navController)

        }
    }

    private fun hideBottomNav() {
        binding.bottomAppBar.hide()
        binding.fabAddUserEntry.hide()
    }

    private fun showBottomNav() {
        binding.bottomAppBar.show()
        binding.fabAddUserEntry.show()
    }
}