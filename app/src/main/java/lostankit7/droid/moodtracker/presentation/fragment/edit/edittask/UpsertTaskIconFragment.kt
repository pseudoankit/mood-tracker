package lostankit7.droid.moodtracker.presentation.fragment.edit.edittask

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.common.utils.hideKeyBoard
import lostankit7.droid.moodtracker.common.utils.showToast
import lostankit7.droid.moodtracker.common.utils.updateTextSize
import lostankit7.droid.moodtracker.data_layer.database.entities.Icon
import lostankit7.droid.moodtracker.data_layer.database.entities.Suggestion
import lostankit7.droid.moodtracker.data_layer.database.entities.TaskIcon
import lostankit7.droid.moodtracker.databinding.FragmentUpsertMoodTaskIconBinding
import lostankit7.droid.moodtracker.databinding.TaskEntryActionBarBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.presentation.adapter.TaskIconRvAdapter
import lostankit7.droid.moodtracker.presentation.adapter.TextRvAdapter
import lostankit7.droid.moodtracker.presentation.viewmodel.TaskEntryViewModel
import lostankit7.droid.moodtracker.utils.*

class UpsertTaskIconFragment :
    BaseDaggerFragment<FragmentUpsertMoodTaskIconBinding, TaskEntryViewModel>() {

    private val args: UpsertTaskIconFragmentArgs by navArgs()
    private val adapter = TaskIconRvAdapter(::onTaskIconSelected, false)
    private val suggestedNamesAdapter = TextRvAdapter(::applySuggestedName)

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.suggestedTaskNamesLiveData.observe(viewLifecycleOwner) {
            suggestedNamesAdapter.submitList(it)
        }
        viewModel.suggestedTaskIconsLiveData.observe(viewLifecycleOwner) {
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

        binding.rvSuggestedNames.adapter = suggestedNamesAdapter
        binding.rvSuggestedNames.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }

    private fun onTaskIconSelected(icon: Icon) {
        binding.tvSelectedIcon.text = icon.icon
    }

    fun saveTaskIcon() {
        when {
            binding.edtSelectedName.text.isBlank() -> {
                requireContext().showToast(resources.getString(R.string.enter_mood_name))
            }
            else -> {
                val icon = TaskIcon(
                    binding.tvSelectedIcon.text.toString(),
                    binding.edtSelectedName.text.toString(),
                    args.category
                )

                args.editTaskIcon?.let {
                    icon.id = it.id
                    viewModel.updateTask(icon)
                } ?: viewModel.insertTask(icon)

                navController.popBackStack()
                requireActivity().hideKeyBoard()
            }
        }
    }

    override fun init() {
        binding.tvSelectedIcon.updateTextSize(R.dimen.small_icon_size)
        binding.tvSelectedIcon.isSolidIcon()

        args.editTaskIcon?.apply {
            binding.tvSelectedIcon.text = icon
            binding.edtSelectedName.setText(name)
        }
    }

   override fun updateActionBar(actionBar: TaskEntryActionBarBinding) = with(actionBar){
        super.updateActionBar(actionBar)
        showBackAndSaveButton()
    }

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[TaskEntryViewModel::class.java]

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentUpsertMoodTaskIconBinding.inflate(layoutInflater)

    companion object {
        private const val spanCount = 6
    }
}