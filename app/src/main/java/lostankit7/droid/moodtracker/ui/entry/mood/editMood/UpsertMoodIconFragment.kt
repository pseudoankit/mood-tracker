package lostankit7.droid.moodtracker.ui.entry.mood.editMood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.databinding.FragmentUpsertMoodIconBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.helper.hideKeyBoard
import lostankit7.droid.moodtracker.helper.showToast
import lostankit7.droid.moodtracker.ui.adapter.MoodIconRvAdapter
import lostankit7.droid.moodtracker.ui.entry.mood.MoodEntryViewModel

class UpsertMoodIconFragment :
    BaseDaggerFragment<FragmentUpsertMoodIconBinding, MoodEntryViewModel>() {

    private var editMoodIcon: MoodIcon? = null
    private val adapter by lazy { MoodIconRvAdapter.newInstance(::onMoodIconSelected) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.suggestedMood.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun initRecyclerView() {
        super.initRecyclerView()

        binding.rvDisplayIcons.layoutManager = GridLayoutManager(requireContext(), spanCount)
        binding.rvDisplayIcons.adapter = adapter
    }

    private fun onMoodIconSelected(icon: Icon) {
        binding.tvSelectedIcon.text = icon.icon
    }

    fun upsertMoodIcon() {
        when {
            binding.edtSelectedName.text.isBlank() -> {
                requireContext().showToast(resources.getString(R.string.enter_mood_name))
            }
            else -> {
                val icon = MoodIcon(
                    binding.tvSelectedIcon.text.toString(),
                    binding.edtSelectedName.text.toString()
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

        binding.tvSelectedIcon.text = editMoodIcon!!.icon
        binding.edtSelectedName.setText(editMoodIcon!!.name)
    }

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentUpsertMoodIconBinding.inflate(layoutInflater)

    companion object {
        private const val spanCount = 6
    }
}