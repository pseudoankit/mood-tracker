package lostankit7.droid.moodtracker.ui.main.entry.mood.editMood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.databinding.FragmentUpsertMoodIconBinding
import lostankit7.droid.moodtracker.helper.showToast
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMood
import lostankit7.droid.moodtracker.ui.main.entry.mood.MoodEntryViewModel
import lostankit7.droid.moodtracker.ui.main.entry.mood.addEntry.RvMoodIconAdapter

class UpsertMoodIconFragment :
    BaseDaggerFragment<FragmentUpsertMoodIconBinding, MoodEntryViewModel>() {

    private val adapter by lazy { RvSuggestedMoodAdapter.newInstance(this::onMoodIconSelected) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

    }

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.suggestedMood.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun setUpRecyclerView() {
        binding.rvSelectMoodIcon.layoutManager = GridLayoutManager(requireContext(), spanCount)
        binding.rvSelectMoodIcon.adapter = adapter
    }

    private fun onMoodIconSelected(icon: SuggestedMood) {
        binding.tvSelectedMoodIcon.text = icon.icon
    }

    fun saveMoodIcon() {
        when {
            binding.edtSelectedMoodName.text.isBlank() -> {
                requireContext().showToast(resources.getString(R.string.enter_mood_name))
            }
            else -> {
                val icon = MoodIcon(
                    binding.tvSelectedMoodIcon.text.toString(),
                    binding.edtSelectedMoodName.text.toString()
                )
                viewModel.insertMoodIcon(icon)
                navController.popBackStack()
                hideKeyBoard()
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