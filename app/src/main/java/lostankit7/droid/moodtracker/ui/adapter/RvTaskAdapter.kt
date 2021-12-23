package lostankit7.droid.moodtracker.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lostankit7.droid.moodtracker.base.BaseRvAdapter
import lostankit7.droid.helper.hide
import lostankit7.droid.helper.show
import lostankit7.droid.moodtracker.databinding.ItemRvTaskBinding
import lostankit7.droid.moodtracker.helper.FontAwesomeIcon
import lostankit7.droid.moodtracker.model.Icon
import lostankit7.droid.moodtracker.model.TaskCategory
import lostankit7.droid.moodtracker.ui.main.newentry.task.TaskEntryFragment
import lostankit7.droid.moodtracker.ui.main.newentry.task.TaskEntryViewModel

class RvTaskAdapter(
    context: Context,
    private val viewModel: TaskEntryViewModel,
    private val taskSelected: (Icon) -> Unit
) : BaseRvAdapter<ItemRvTaskBinding, TaskCategory>(viewModel.getTaskCategories(), context) {

    override fun bindViewHolder(item: TaskCategory, position: Int, binding: ItemRvTaskBinding) {

        binding.tvTaskCategory.text = item.category

        binding.toggleTaskCategory(item, true)
        binding.rvTaskIcon.setUpRecyclerView(item.category)

        binding.tvDropDownIcon.setOnClickListener { binding.toggleTaskCategory(item) }
        binding.llTaskCategory.setOnClickListener { binding.toggleTaskCategory(item) }
    }

    private fun ItemRvTaskBinding.toggleTaskCategory(
        item: TaskCategory,
        isInitial: Boolean = false
    ) {
        if (!isInitial) item.isExpanded = !item.isExpanded
        if (item.isExpanded) {
            tvDropDownIcon.text = FontAwesomeIcon.collapsed
            rvTaskIcon.show()
        } else {
            tvDropDownIcon.text = FontAwesomeIcon.expanded
            rvTaskIcon.hide()
        }
    }

    private fun RecyclerView.setUpRecyclerView(category: String) {
        layoutManager = GridLayoutManager(context, TaskEntryFragment.taskSpan)
        hasFixedSize()

        val mAdapter =
            RvTaskItemAdapter(mContext, viewModel.getTaskOfCategory(category), taskSelected)
        adapter = mAdapter
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ) = ItemRvTaskBinding.inflate(layoutInflater, parent, attachToParent)

    companion object {
        fun createInstance(context: Context, vm: TaskEntryViewModel, taskSelected: (Icon) -> Unit) =
            RvTaskAdapter(context, vm, taskSelected)
    }
}

