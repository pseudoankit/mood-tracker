package lostankit7.android.entry_presentation.fragment.addEntry

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import lostankit7.android.entry_domain.entities.MoodEntry
import lostankit7.android.entry_domain.entities.MoodIcon
import lostankit7.android.entry_presentation.adapter.RvMoodIconAdapter
import lostankit7.android.entry_presentation.databinding.FragmentAddMoodEntryBinding
import lostankit7.android.entry_presentation.utils.DIUtils.entryComponent
import lostankit7.android.entry_presentation.viewmodel.MoodEntryViewModel
import lostankit7.droid.moodtracker.core.presentation.utils.DateTimeUtils.getCurrentDate
import lostankit7.droid.moodtracker.core.presentation.utils.DateTimeUtils.getCurrentTime
import lostankit7.droid.moodtracker.core.presentation.utils.DateTimeUtils.getSelectedDate
import lostankit7.droid.moodtracker.core.presentation.utils.DateTimeUtils.getSelectedTime
import lostankit7.droid.moodtracker.core.presentation.fragment.BaseDaggerFragment

class AddMoodEntryFragment : BaseDaggerFragment<FragmentAddMoodEntryBinding, MoodEntryViewModel>() {

    private val moodIconAdapter = RvMoodIconAdapter(context, ::onMoodIconSelected)

    override suspend fun registerObservers() {
        super.registerObservers()
        viewModel.moodIconsLiveData.observe(viewLifecycleOwner) {
            moodIconAdapter.submitList(it)
        }
    }

    private fun onMoodIconSelected(icon: MoodIcon) {
        val moodEntry = MoodEntry(
            icon, binding.layoutDate.tvText.text.toString(),
            binding.layoutTime.tvText.text.toString()
        )
        navigateTo(
            AddMoodEntryFragmentDirections.actionAddMoodEntryFragmentToAddTaskEntryFragment(
                moodEntry
            )
        )
    }

    override fun initListeners() {

        binding.btnBack.setOnClickListener { findNavController().popBackStack() }

        binding.btnEditMood.setOnClickListener {
            navigateTo(
                AddMoodEntryFragmentDirections.actionAddMoodEntryFragmentToDisplayMoodIconsFragment()
            )
        }

        binding.layoutDate.setOnClickListener {
            context?.getSelectedDate(binding.layoutDate.tvText.text.toString()) {
                binding.layoutDate.tvText.text = it
            }
        }

        binding.layoutTime.setOnClickListener {
            context?.getSelectedTime(binding.layoutTime.tvText.text.toString()) {
                binding.layoutTime.tvText.text = it
            }
        }

    }

    override fun init() {
        binding.layoutDate.tvText.text = getCurrentDate()
        binding.layoutTime.tvText.text = getCurrentTime()
    }

    override fun initRecyclerView() {
        super.initRecyclerView()
        binding.rvMoodIcon.adapter = moodIconAdapter
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[MoodEntryViewModel::class.java]

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentAddMoodEntryBinding.inflate(layoutInflater)


    override fun injectFragment() {
        activity?.entryComponent?.inject(this)
    }

}