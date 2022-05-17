package lostankit7.android.entry_presentation.fragment.editEntry.editmood

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lostankit7.android.entry_domain.entities.Icon
import lostankit7.android.entry_domain.entities.Suggestion
import lostankit7.android.entry_presentation.AddUserEntryActivity
import lostankit7.android.entry_presentation.adapter.ChipsRvAdapter
import lostankit7.android.entry_presentation.adapter.MoodIconRvAdapter
import lostankit7.android.entry_presentation.databinding.FragmentUpsertMoodTaskIconBinding
import lostankit7.android.entry_presentation.utils.DIUtils.entryComponent
import lostankit7.android.entry_presentation.viewmodel.MoodEntryViewModel
import lostankit7.droid.moodtracker.core.presentation.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.core.presentation.utils.ActionBarUtils.applyDefault
import lostankit7.droid.moodtracker.core.presentation.utils.ActionBarUtils.showSaveButton
import lostankit7.droid.moodtracker.core.presentation.utils.UiUtils.hideKeyBoard

class UpsertMoodIconFragment :
    BaseDaggerFragment<FragmentUpsertMoodTaskIconBinding, MoodEntryViewModel>() {

    private val args: UpsertMoodIconFragmentArgs by navArgs()
    private val adapter = MoodIconRvAdapter(::onMoodIconSelected)
    private val suggestedNamesAdapter = ChipsRvAdapter.createInstance(::applySuggestedName)

    override suspend fun registerObservers() {
        viewModel.errorMessageLiveData.observe(viewLifecycleOwner) { message ->
            context?.let { context -> message.asString(context) }
        }

        viewModel.suggestedMoodNamesLiveData.observe(viewLifecycleOwner) {
            suggestedNamesAdapter.submitList(it)
        }
        viewModel.suggestedMoodLiveData.observe(viewLifecycleOwner) {
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
        viewModel.saveMoodIcon(
            binding.edtSelectedName.text.toString(),
            binding.tvSelectedIcon.text.toString(),
            args.icon?.id
        )
        activity?.hideKeyBoard()
        navController.popBackStack()
    }

    override fun init() {
        args.icon?.let {
            binding.tvSelectedIcon.text = it.icon
            binding.edtSelectedName.setText(it.name)
        }
    }

    override fun updateActionBar() {
        (activity as? AddUserEntryActivity)?.actionBar?.apply {
            applyDefault()
            showSaveButton()
        }
    }

    override fun injectFragment() {
        activity?.entryComponent?.inject(this)
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[MoodEntryViewModel::class.java]

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentUpsertMoodTaskIconBinding.inflate(layoutInflater)

    companion object {
        private const val spanCount = 6
    }
}