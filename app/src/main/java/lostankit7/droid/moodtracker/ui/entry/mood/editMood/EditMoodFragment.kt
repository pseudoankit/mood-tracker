package lostankit7.droid.moodtracker.ui.entry.mood.editMood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.databinding.FragmentEditMoodBinding
import lostankit7.droid.moodtracker.helper.constant.Action.DELETE
import lostankit7.droid.moodtracker.helper.constant.Action.EDIT
import lostankit7.droid.moodtracker.ui.entry.mood.MoodEntryViewModel

class EditMoodFragment : BaseDaggerFragment<FragmentEditMoodBinding, MoodEntryViewModel>() {

    private val adapter by lazy { RvEditMoodIconAdapter.newInstance(this::onItemClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun onItemClick(action: Int, item: MoodIcon) {
        when (action) {
            EDIT -> navigateTo(
                R.id.action_editMoodFragment_to_upsertMoodIconFragment,
                bundleOf(resources.getString(R.string.arg_to_upsertMoodFrag) to item)
            )

            DELETE -> viewModel.deleteMoodIcon(item)
        }
    }

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.moodIcons.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun initListeners() {
        binding.btnAddNewMood.setOnClickListener {
            navigateTo(R.id.action_editMoodFragment_to_upsertMoodIconFragment)
        }
    }

    private fun setUpRecyclerView() {
        binding.rvMoodIcon.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMoodIcon.adapter = adapter
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentEditMoodBinding.inflate(layoutInflater)

    override fun viewModel() = MoodEntryViewModel::class.java
    override fun injectFragment() {
        appComponent.inject(this)
    }
}