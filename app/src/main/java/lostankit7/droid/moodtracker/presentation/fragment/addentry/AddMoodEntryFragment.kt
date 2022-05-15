package lostankit7.droid.moodtracker.presentation.fragment.addentry

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.databinding.FragmentAddMoodEntryBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.model.MoodEntry
import lostankit7.droid.moodtracker.presentation.adapter.RvMoodIconAdapter
import lostankit7.droid.moodtracker.presentation.viewmodel.MoodEntryViewModel
import lostankit7.droid.moodtracker.utils.*

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
            requireContext().getSelectedDate(binding.layoutDate.tvText.text.toString()) {
                binding.layoutDate.tvText.text = it
            }
        }

        binding.layoutTime.setOnClickListener {
            requireContext().getSelectedTime(binding.layoutTime.tvText.text.toString()) {
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


    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

}