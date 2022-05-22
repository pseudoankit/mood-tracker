package lostankit7.android.entry_presentation

import android.view.LayoutInflater
import lostankit7.android.entry_presentation.databinding.FragmentAddUserEntryHostBinding
import lostankit7.android.entry_presentation.fragment.addEntry.AddTaskEntryFragment
import lostankit7.android.entry_presentation.fragment.editEntry.editmood.UpsertMoodIconFragment
import lostankit7.android.entry_presentation.fragment.editEntry.edittask.UpsertTaskIconFragment
import lostankit7.droid.moodtracker.core.databinding.CommonActionBarBinding
import lostankit7.droid.moodtracker.core.presentation.fragment.BaseFragment
import lostankit7.droid.moodtracker.core.presentation.utils.ActionBarUtils.applyDefault
import lostankit7.droid.moodtracker.core.presentation.utils.findNavHost

class AddUserEntryHostFragment : BaseFragment<FragmentAddUserEntryHostBinding>() {

    override fun init() {
        //todo
        navController = findNavHost(binding.fragmentContainerAddUserEntry.id)

    }

    override fun initListeners() {

        binding.actionBar.btnBack.setOnClickListener {
            navController.popBackStack()
        }

        binding.actionBar.btnSave.setOnClickListener {
            when (val fragment =
                childFragmentManager.findFragmentById(binding.fragmentContainerAddUserEntry.id)?.childFragmentManager?.primaryNavigationFragment) {
                is AddTaskEntryFragment -> fragment.saveEntry()
                is UpsertMoodIconFragment -> fragment.saveMoodIcon()
                is UpsertTaskIconFragment -> fragment.saveTaskIcon()
            }
        }

        navController.addOnDestinationChangedListener { _, _, _ ->
            binding.actionBar.applyDefault()
        }
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentAddUserEntryHostBinding.inflate(layoutInflater)

    val actionBar: CommonActionBarBinding?
        get() {
            return try {
                binding.actionBar
            } catch (e: Exception) {
                null
            }
        }
}