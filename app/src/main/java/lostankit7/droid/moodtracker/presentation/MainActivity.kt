package lostankit7.droid.moodtracker.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.databinding.ActivityMainBinding
import lostankit7.droid.moodtracker.databinding.TaskEntryActionBarBinding
import lostankit7.droid.moodtracker.presentation.fragment.addentry.AddTaskEntryFragment
import lostankit7.droid.moodtracker.presentation.fragment.edit.editmood.UpsertMoodIconFragment
import lostankit7.droid.moodtracker.presentation.fragment.edit.edittask.UpsertTaskIconFragment
import lostankit7.droid.moodtracker.utils.hide
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
        binding.actionBar.btnBack.setOnClickListener {
            navController.popBackStack()
        }
        binding.actionBar.btnSave.setOnClickListener {
            when (val fragment =
                supportFragmentManager.findFragmentById(R.id.fragment_container)?.childFragmentManager?.primaryNavigationFragment) {
                is AddTaskEntryFragment -> fragment.saveEntry()
                is UpsertMoodIconFragment -> fragment.saveMoodIcon()
                is UpsertTaskIconFragment -> fragment.saveTaskIcon()
            }
        }
    }

    private fun addEntryButtonClicked() {
        navController.navigate(R.id.addMoodEntryFragment)
    }

    private fun onNavControllerDestinationChanged(
        navController: NavController, destination: NavDestination, bundle: Bundle?,
    ) {
        when (destination.id) {
            R.id.calendarFragment, R.id.moreFragment, R.id.displayAllUserEntriesFragment -> {
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

    private fun showBottomNav() {
        binding.bottomLayout.show()
        binding.fragmentBottomGuide.show()
    }

    private fun hideBottomNav() {
        binding.bottomLayout.hide()
        binding.fragmentBottomGuide.hide()
    }

    fun actionBar(): TaskEntryActionBarBinding? {
        return if (!::binding.isInitialized) null
        else binding.actionBar
    }
}