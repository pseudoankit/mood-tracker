package lostankit7.droid.moodtracker.ui.fragment.edit.editmood

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.Suggestion
import lostankit7.droid.moodtracker.databinding.FragmentUpsertMoodTaskIconBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.ui.adapter.MoodIconRvAdapter
import lostankit7.droid.moodtracker.ui.adapter.TextRvAdapter
import lostankit7.droid.moodtracker.ui.viewmodel.MoodEntryViewModel
import lostankit7.droid.moodtracker.utils.hideKeyBoard
import lostankit7.droid.moodtracker.utils.showToast

class UpsertMoodIconFragment :
    BaseDaggerFragment<FragmentUpsertMoodTaskIconBinding, MoodEntryViewModel>() {

    private val args: UpsertMoodIconFragmentArgs by navArgs()
    private val adapter = MoodIconRvAdapter(::onMoodIconSelected)
    private val suggestedNamesAdapter = TextRvAdapter.createInstance(::applySuggestedName)

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.suggestedMoodNames.observe(viewLifecycleOwner) {
            suggestedNamesAdapter.submitList(it)
        }
        viewModel.suggestedMood.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun applySuggestedName(it: Suggestion) {
        binding.edtSelectedName.setText(it.name)
    }

    override fun initRecyclerView() {
        super.initRecyclerView()

        binding.rvDisplayIcons.layoutManager = GridLayoutManager(requireContext(), spanCount)
        binding.rvDisplayIcons.adapter = adapter

        binding.rvSuggestedNames.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.rvSuggestedNames.adapter = suggestedNamesAdapter
    }

    private fun onMoodIconSelected(icon: Icon) {
        binding.tvSelectedIcon.text = icon.icon
    }

    fun saveMoodIcon() {
        when {
            binding.edtSelectedName.text.isBlank() -> {
                requireContext().showToast(resources.getString(R.string.enter_mood_name))
            }
            else -> {
                val icon = MoodIcon(
                    binding.tvSelectedIcon.text.toString(),
                    binding.edtSelectedName.text.toString()
                )

                args.icon?.let {
                    icon.id = it.id
                    viewModel.updateMoodIcon(icon)
                } ?: viewModel.insertMoodIcon(icon)

                navController.popBackStack()
                requireActivity().hideKeyBoard()
            }
        }
    }

    override fun init() {
        args.icon?.let {
            binding.tvSelectedIcon.text = it.icon
            binding.edtSelectedName.setText(it.name)
        }
    }

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[MoodEntryViewModel::class.java]

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentUpsertMoodTaskIconBinding.inflate(layoutInflater)

    companion object {
        private const val spanCount = 6
    }
}