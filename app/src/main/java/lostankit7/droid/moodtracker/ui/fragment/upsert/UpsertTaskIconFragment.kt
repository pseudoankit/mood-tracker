package lostankit7.droid.moodtracker.ui.fragment.upsert

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.Suggestion
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.databinding.FragmentUpsertMoodIconBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.utils.asTextDimen
import lostankit7.droid.moodtracker.utils.hideKeyBoard
import lostankit7.droid.moodtracker.utils.showToast
import lostankit7.droid.moodtracker.ui.adapter.TaskIconRvAdapter
import lostankit7.droid.moodtracker.ui.adapter.TextRvAdapter
import lostankit7.droid.moodtracker.ui.viewmodel.TaskEntryViewModel

class UpsertTaskIconFragment :
    BaseDaggerFragment<FragmentUpsertMoodIconBinding, TaskEntryViewModel>() {

    private var editTaskIcon: TaskIcon? = null
    private var category: String? = null
    private val adapter by lazy { TaskIconRvAdapter.newInstance(::onTaskIconSelected, false) }
    private val suggestedNamesAdapter by lazy { TextRvAdapter.createInstance(::suggestedNameTap) }

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.suggestedTaskNames.observe(viewLifecycleOwner) {
            suggestedNamesAdapter.submitList(it)
        }
        viewModel.suggestedTaskIcons.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun suggestedNameTap(it: Suggestion) {
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
                    category!!
                )

                if (editTaskIcon == null) {
                    viewModel.insertTask(icon)
                } else {
                    icon.id = editTaskIcon!!.id
                    viewModel.updateTask(icon)
                }
                navController.popBackStack()
                requireActivity().hideKeyBoard()
            }
        }
    }

    override fun init() {
        binding.tvSelectedIcon.asTextDimen(R.dimen.small_icon_size)
        binding.tvSelectedIcon.isSolidIcon()

        category = arguments?.getString(resources.getString(R.string.category_to_upsertTaskFrag))
        if (category == null) navController.popBackStack()
        editTaskIcon =
            arguments?.getParcelable(resources.getString(R.string.taskIcon_to_upsertTaskFrag))
        if (editTaskIcon == null) return

        binding.tvSelectedIcon.text = editTaskIcon!!.icon
        binding.edtSelectedName.setText(editTaskIcon!!.name)
    }

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[TaskEntryViewModel::class.java]

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentUpsertMoodIconBinding.inflate(layoutInflater)

    companion object {
        private const val spanCount = 6
    }
}