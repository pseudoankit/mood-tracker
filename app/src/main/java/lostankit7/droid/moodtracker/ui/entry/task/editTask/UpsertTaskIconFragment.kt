package lostankit7.droid.moodtracker.ui.entry.task.editTask

import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDaggerFragment
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.databinding.FragmentUpsertMoodIconBinding
import lostankit7.droid.moodtracker.di.AppComponent
import lostankit7.droid.moodtracker.helper.hideKeyBoard
import lostankit7.droid.moodtracker.helper.showToast
import lostankit7.droid.moodtracker.ui.adapter.DisplayIconRvAdapter
import lostankit7.droid.moodtracker.ui.entry.task.TaskEntryViewModel

class UpsertTaskIconFragment :
    BaseDaggerFragment<FragmentUpsertMoodIconBinding, TaskEntryViewModel>() {

    private var editTaskIcon: TaskIcon? = null
    private var category: String? = null
    private val adapter by lazy { DisplayIconRvAdapter.newInstance(::onTaskIconSelected) }

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.suggestedTaskIcons.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun initRecyclerView() {
        super.initRecyclerView()
        binding.rvDisplayIcons.layoutManager = GridLayoutManager(requireContext(), spanCount)
        binding.rvDisplayIcons.adapter = adapter
    }

    private fun onTaskIconSelected(icon: Icon) {
        binding.tvSelectedIcon.text = icon.icon
    }

    fun upsertTaskIcon() {
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

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentUpsertMoodIconBinding.inflate(layoutInflater)

    companion object {
        private const val spanCount = 6
    }
}