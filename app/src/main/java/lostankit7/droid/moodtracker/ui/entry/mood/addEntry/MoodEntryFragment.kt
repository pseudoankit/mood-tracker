package lostankit7.droid.moodtracker.ui.entry.mood.addEntry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.GridLayoutManager
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.MyApplication
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.databinding.FragmentMoodEntryBinding
import lostankit7.droid.moodtracker.helper.getCurrentDate
import lostankit7.droid.moodtracker.helper.getCurrentTime
import lostankit7.droid.moodtracker.helper.getSelectedDate
import lostankit7.droid.moodtracker.helper.getSelectedTime
import lostankit7.droid.moodtracker.model.MoodEntry
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.ui.entry.mood.MoodEntryViewModel

class MoodEntryFragment : BaseDaggerFragment<FragmentMoodEntryBinding, MoodEntryViewModel>() {

    private val moodIconAdapter by lazy {
        RvMoodIconAdapter.newInstance(
            requireContext(),
            this@MoodEntryFragment::onMoodIconSelected
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dateTimeLayoutOperations()
        setUpRecyclerView()
    }

    override suspend fun registerObservers() {
        super.registerObservers()
        viewModel.moodIcons.observe(viewLifecycleOwner) {
            moodIconAdapter.submitList(it)
        }
    }

    private fun setUpRecyclerView() = with(binding.rvMoodIcon) {
        layoutManager = GridLayoutManager(requireContext(), moodRvSpan)
        binding.rvMoodIcon.adapter = moodIconAdapter
    }

    private fun onMoodIconSelected(icon: MoodIcon) {
        val moodEntry = MoodEntry(
            icon,
            binding.layoutDate.tvText.text.toString(),
            binding.layoutTime.tvText.text.toString()
        )
        val bundle = bundleOf(resources.getString(R.string.arg_to_addNewTaskFrag) to moodEntry)
        navigateTo(R.id.action_addMoodEntryFragment_to_addTaskEntryFragment, bundle)
    }

    private fun dateTimeLayoutOperations() {
        binding.layoutDate.apply {
            setOnClickListener {
                requireContext().getSelectedDate(binding.layoutDate.tvText.text.toString()) {
                    tvText.text = it
                }
            }
        }

        binding.layoutTime.apply {
            setOnClickListener {
                requireContext().getSelectedTime(tvText.text.toString()) {
                    tvText.text = it
                }
            }
        }
    }

    override fun initListeners() {
        binding.btnEditMood.setOnClickListener {
            navigateTo(R.id.action_addMoodEntryFragment_to_editMoodFragment)
        }
    }

    override fun init() {
        binding.layoutDate.tvText.text = getCurrentDate()
        binding.layoutTime.tvText.text = getCurrentTime()
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentMoodEntryBinding.inflate(layoutInflater)

    override fun viewModel() = MoodEntryViewModel::class.java

    override fun injectFragment() {
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    companion object {
        private const val moodRvSpan = 5
    }
}