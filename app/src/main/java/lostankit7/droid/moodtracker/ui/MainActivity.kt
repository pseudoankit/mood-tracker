package lostankit7.droid.moodtracker.ui

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import lostankit7.droid.helper.hide
import lostankit7.droid.helper.show
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.databinding.ActivityMainBinding
import lostankit7.droid.moodtracker.helper.ANIMATE_TOP_BOTTOM
import lostankit7.droid.moodtracker.helper.navOptions
import lostankit7.droid.moodtracker.ui.entry.mood.editMood.UpsertMoodIconFragment
import lostankit7.droid.moodtracker.ui.entry.task.addTask.TaskEntryFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()

        navController = Navigation.findNavController(this, R.id.fragment_container)
        navController.addOnDestinationChangedListener(::onNavControllerDestinationChanged)

        setUpBottomNavigation()
    }

    private fun initListener() {
        binding.fabAddUserEntry.setOnClickListener { addEntryButtonClicked() }

        binding.actionBar.btnBack.setOnClickListener {
            (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(this.currentFocus?.windowToken,0)
            navController.popBackStack()
        }

        binding.actionBar.btnSave.setOnClickListener { onSaveClicked() }
    }

    private fun onSaveClicked() {
        when (val fragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container)?.childFragmentManager?.primaryNavigationFragment) {
            is TaskEntryFragment -> fragment.saveEntry()
            is UpsertMoodIconFragment -> fragment.saveMoodIcon()
        }
    }

    private fun addEntryButtonClicked() {
        navController.navigate(R.id.addMoodEntryFragment, null, navOptions(ANIMATE_TOP_BOTTOM))
    }

    private fun onNavControllerDestinationChanged(
        navController: NavController,
        destination: NavDestination,
        bundle: Bundle?
    ) {
        hideActionBarLeftSubIcon()
        showActionBar()
        hideBottomNav()
        hideSaveButton()

        handleUI(destination.id)
    }

    private fun handleUI(frag: Int) {
        when (frag) {
            R.id.splashFragment -> {
                hideActionBar()
            }
            R.id.userEntriesFragment, R.id.calendarFragment, R.id.moreFragment -> {
                hideActionBar()
                showBottomNav()
            }
            R.id.addTaskEntryFragment -> {
                showActionBarLeftSubIcon()
                showSaveButton()
            }
            R.id.upsertMoodIconFragment -> {
                showSaveButton()
            }
        }
    }

    private fun setUpBottomNavigation() {
        with(binding.bottomNavBar) {
            background = null
            menu.getItem(2).isEnabled = false
            NavigationUI.setupWithNavController(this, navController)
        }
    }

    private fun hideActionBarLeftSubIcon() {
        binding.actionBar.leftIcon2.hide()
        binding.actionBar.leftIcon1.text = resources.getString(R.string.fas_circular_back)
    }

    private fun showActionBarLeftSubIcon() {
        binding.actionBar.leftIcon2.show()
        binding.actionBar.leftIcon1.text = resources.getString(R.string.fas_back)
    }

    private fun showSaveButton() {
        binding.actionBar.btnSave.show()
    }

    private fun hideSaveButton() {
        binding.actionBar.btnSave.hide()
    }

    private fun hideActionBar() {
        binding.actionBar.container.hide()
    }

    private fun showActionBar() {
        binding.actionBar.container.show()
    }

    private fun hideBottomNav() {
        binding.bottomLayout.hide()
        binding.fragmentBottomGuide.hide()
    }

    private fun showBottomNav() {
        binding.bottomLayout.show()
        binding.fragmentBottomGuide.show()
    }

    fun actionBar() = binding.actionBar
}