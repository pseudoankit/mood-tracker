package lostankit7.droid.moodtracker.ui.entry.mood.editMood

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
import lostankit7.droid.moodtracker.helper.hideKeyBoard
import lostankit7.droid.moodtracker.ui.entry.mood.MoodEntryViewModel

class UpsertMoodIconFragment :
    BaseDaggerFragment<FragmentUpsertMoodIconBinding, MoodEntryViewModel>() {

    private var editMoodIcon: MoodIcon? = null
    private val adapter by lazy { RvSuggestedMoodAdapter.newInstance(::onMoodIconSelected) }

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

                if (editMoodIcon == null) {
                    viewModel.insertMoodIcon(icon)
                } else {
                    icon.id = editMoodIcon!!.id
                    viewModel.updateMoodIcon(icon)
                }
                navController.popBackStack()
                requireActivity().hideKeyBoard()
            }
        }
    }

    override fun init() {
        editMoodIcon = arguments?.getParcelable(resources.getString(R.string.arg_to_upsertMoodFrag))
        if (editMoodIcon == null) return

        binding.tvSelectedMoodIcon.text = editMoodIcon!!.icon
        binding.edtSelectedMoodName.setText(editMoodIcon!!.name)
    }

    override fun injectFragment() {
        appComponent.inject(this)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentUpsertMoodIconBinding.inflate(layoutInflater)

    companion object {
        private const val spanCount = 6
    }
}