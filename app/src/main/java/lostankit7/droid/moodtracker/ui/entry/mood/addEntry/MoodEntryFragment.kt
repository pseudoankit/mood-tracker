package lostankit7.droid.moodtracker.ui.entry.mood.addEntry

import android.view.LayoutInflater
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.GridLayoutManager
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.databinding.FragmentMoodEntryBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.helper.getCurrentDate
import lostankit7.droid.moodtracker.helper.getCurrentTime
import lostankit7.droid.moodtracker.helper.getSelectedDate
import lostankit7.droid.moodtracker.helper.getSelectedTime
import lostankit7.droid.moodtracker.model.MoodEntry
import lostankit7.droid.moodtracker.ui.entry.mood.MoodEntryViewModel

class MoodEntryFragment : BaseDaggerFragment<FragmentMoodEntryBinding, MoodEntryViewModel>() {

    private val moodIconAdapter by lazy {
        RvMoodIconAdapter.newInstance(requireContext(), ::onMoodIconSelected)
    }

    override suspend fun registerObservers() {
        super.registerObservers()
        viewModel.moodIcons.observe(viewLifecycleOwner) {
            moodIconAdapter.submitList(it)
        }
    }

    override fun initRecyclerView() {

        with(binding.rvMoodIcon) {
            layoutManager = GridLayoutManager(requireContext(), spanCount)
            binding.rvMoodIcon.adapter = moodIconAdapter
        }
    }

    private fun onMoodIconSelected(icon: MoodIcon) {
        val moodEntry = MoodEntry(
            icon,
            binding.layoutDate.tvText.text.toString(),
            binding.layoutTime.tvText.text.toString()
        )
        val bundle = bundleOf(resources.getString(R.string.arg_to_addNewTaskFrag) to moodEntry)
        navigateTo(R.id.action_moodEntryFragment_to_taskEntryFragment, bundle)
    }

    override fun initListeners() {
        binding.btnEditMood.setOnClickListener {
            navigateTo(R.id.action_moodEntryFragment_to_editMoodFragment)
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

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentMoodEntryBinding.inflate(layoutInflater)


    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    companion object {
        private const val spanCount = 5
    }
}