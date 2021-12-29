package lostankit7.droid.moodtracker.ui.main.entry.mood.editMood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.base.BaseFragment
import lostankit7.droid.moodtracker.databinding.FragmentEditMoodBinding
import lostankit7.droid.moodtracker.ui.main.entry.mood.MoodEntryViewModel
import lostankit7.droid.moodtracker.ui.main.entry.mood.addEntry.RvMoodIconAdapter

class EditMoodFragment : BaseDaggerFragment<FragmentEditMoodBinding, MoodEntryViewModel>() {

    private val adapter by lazy { RvEditMoodIconAdapter.newInstance() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
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