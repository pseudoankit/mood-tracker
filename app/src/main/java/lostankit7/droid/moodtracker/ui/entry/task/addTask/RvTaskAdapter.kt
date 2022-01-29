package lostankit7.droid.moodtracker.ui.entry.task.addTask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.databinding.ItemRvExpandableViewBinding
import lostankit7.droid.moodtracker.helper.constant.FontAwesomeIcon
import lostankit7.droid.moodtracker.helper.hide
import lostankit7.droid.moodtracker.helper.show
import lostankit7.droid.moodtracker.ui.adapter.TaskIconRvAdapter

class RvTaskAdapter(
    private val getTaskIcons: (String, TaskIconRvAdapter) -> Unit,
    private val taskSelected: (Icon) -> Unit
) : BaseDiffRvAdapter<ItemRvExpandableViewBinding, TaskCategory>() {

    override fun bindViewHolder(
        item: TaskCategory,
        position: Int,
        binding: ItemRvExpandableViewBinding
    ) {

        binding.txtTitle.text = item.name

        binding.toggleTaskCategory(item, true)
        binding.rvItems.setUpRecyclerView(item.name)

        binding.tvDropDownIcon.setOnClickListener { binding.toggleTaskCategory(item) }
        binding.llTaskCategory.setOnClickListener { binding.toggleTaskCategory(item) }
    }

    private fun ItemRvExpandableViewBinding.toggleTaskCategory(
        item: TaskCategory,
        isInitial: Boolean = false
    ) {
        if (!isInitial) item.isExpanded = !item.isExpanded
        if (item.isExpanded) {
            tvDropDownIcon.text = FontAwesomeIcon.collapsed
            rvItems.show()
        } else {
            tvDropDownIcon.text = FontAwesomeIcon.expanded
            rvItems.hide()
        }
    }

    private fun RecyclerView.setUpRecyclerView(category: String) {
        layoutManager = GridLayoutManager(context, TaskEntryFragment.taskSpan)

        val mAdapter = TaskIconRvAdapter.newInstance(taskSelected, true)
        adapter = mAdapter

        getTaskIcons.invoke(category, mAdapter)
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemRvExpandableViewBinding.inflate(layoutInflater, parent, attachToParent)

    companion object {
        fun createInstance(
            getTaskIcons: (String, TaskIconRvAdapter) -> Unit,
            taskSelected: (Icon) -> Unit
        ) = RvTaskAdapter(getTaskIcons, taskSelected)
    }
}

