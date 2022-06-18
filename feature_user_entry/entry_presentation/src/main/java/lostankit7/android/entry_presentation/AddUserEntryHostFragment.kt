package lostankit7.android.entry_presentation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import lostankit7.android.entry_presentation.databinding.FragmentAddUserEntryHostBinding
import lostankit7.android.entry_presentation.fragment.addEntry.AddTaskEntryFragment
import lostankit7.android.entry_presentation.fragment.editEntry.editmood.UpsertMoodIconFragment
import lostankit7.android.entry_presentation.fragment.editEntry.edittask.UpsertTaskIconFragment
import lostankit7.android.entry_presentation.utils.ActionBarUtils.addMoodEntryFragment
import lostankit7.android.entry_presentation.utils.ActionBarUtils.addTaskEntryFragment
import lostankit7.android.entry_presentation.utils.ActionBarUtils.applyDefault
import lostankit7.android.entry_presentation.utils.ActionBarUtils.upsertMoodTaskFragment
import lostankit7.droid.moodtracker.core.presentation.base.fragment.BaseFragment
import lostankit7.droid.moodtracker.core.presentation.utils.findNavHost
import lostankit7.droid.moodtracker.core.presentation.utils.getCurrentFragment

class AddUserEntryHostFragment : BaseFragment<FragmentAddUserEntryHostBinding>() {

    override fun init() {
        navController = findNavHost(binding.fragmentContainerAddUserEntry.id)
    }

    private fun destinationChangedListener(
        controller: NavController, destination: NavDestination, arguments: Bundle?,
    ) {
        binding.actionBar.applyDefault()
        when (destination.id) {
            R.id.addMoodEntryFragment -> {
                binding.actionBar.addMoodEntryFragment()
            }
            R.id.addTaskEntryFragment -> {
                binding.actionBar.addTaskEntryFragment(arguments)
            }
            R.id.upsertMoodIconFragment, R.id.upsertTaskIconFragment -> {
                binding.actionBar.upsertMoodTaskFragment()
            }
        }
    }

    override fun initListeners() {

        navController.addOnDestinationChangedListener(::destinationChangedListener)

        binding.actionBar.btnBack.setOnClickListener {
            navController.popBackStack()
        }

        binding.actionBar.btnSave.setOnClickListener {
            when (val fragment = getCurrentFragment(binding.fragmentContainerAddUserEntry.id)) {
                is AddTaskEntryFragment -> fragment.saveEntry()
                is UpsertMoodIconFragment -> fragment.saveMoodIcon()
                is UpsertTaskIconFragment -> fragment.saveTaskIcon()
            }
        }

    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentAddUserEntryHostBinding.inflate(layoutInflater)

}