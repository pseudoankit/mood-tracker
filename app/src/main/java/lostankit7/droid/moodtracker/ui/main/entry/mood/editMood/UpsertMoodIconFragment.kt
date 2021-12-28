package lostankit7.droid.moodtracker.ui.main.entry.mood.editMood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.databinding.FragmentUpsertMoodIconBinding
import lostankit7.droid.moodtracker.helper.showToast
import lostankit7.droid.moodtracker.model.Icon
import lostankit7.droid.moodtracker.ui.main.entry.mood.MoodEntryViewModel
import lostankit7.droid.moodtracker.ui.main.entry.mood.addEntry.RvMoodIconAdapter

class UpsertMoodIconFragment :
    BaseDaggerFragment<FragmentUpsertMoodIconBinding, MoodEntryViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() = with(binding.rvSelectMoodIcon) {
        layoutManager = GridLayoutManager(requireContext(), spanCount)
        val mAdapter = RvMoodIconAdapter.newInstance(
            requireContext(),
            viewModel.suggestedMoodIconList(),
            this@UpsertMoodIconFragment::onMoodIconSelected,
            RvMoodIconAdapter.SUGGESTION_ADAPTER
        )
        adapter = mAdapter
    }

    private fun onMoodIconSelected(icon: Icon) {
        binding.tvSelectedMoodIcon.text = icon.icon
    }

    override fun initListeners() {
        binding.actionBar.llRight.setOnClickListener {
            saveMoodIcon()
        }
    }

    private fun saveMoodIcon() {
        when {
            binding.tvSelectedMoodIcon.text.isBlank() -> {
                requireContext().showToast(resources.getString(R.string.error_empty_mood_icon))
            }
            binding.edtSelectedMoodName.text.isBlank() -> {
                requireContext().showToast(resources.getString(R.string.enter_mood_name))
            }
            else -> {
                val icon = Icon(
                    binding.tvSelectedMoodIcon.text.toString(),
                    binding.edtSelectedMoodName.text.toString()
                )
                viewModel.insertMoodIcon(icon)
            }
        }
    }

    override fun injectFragment() {
        appComponent.inject(this)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentUpsertMoodIconBinding.inflate(layoutInflater)

    override fun viewModel() = MoodEntryViewModel::class.java

    companion object {
        private const val spanCount = 6
    }
}