package lostankit7.droid.moodtracker.ui.entry.task.addTask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.databinding.ItemRvTaskBinding
import lostankit7.droid.moodtracker.helper.constant.FontAwesomeIcon
import lostankit7.droid.moodtracker.helper.hide
import lostankit7.droid.moodtracker.helper.show
import lostankit7.droid.moodtracker.ui.adapter.TaskIconRvAdapter

class RvTaskAdapter(
    private val getTaskIcons: (String, TaskIconRvAdapter) -> Unit,
    private val taskSelected: (Icon) -> Unit
) : BaseDiffRvAdapter<ItemRvTaskBinding, TaskCategory>() {

    override fun bindViewHolder(item: TaskCategory, position: Int, binding: ItemRvTaskBinding) {

        binding.tvTaskCategory.text = item.name

        binding.toggleTaskCategory(item, true)
        binding.rvTaskIcon.setUpRecyclerView(item.name)

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

        val mAdapter = TaskIconRvAdapter.newInstance(taskSelected,true)
        adapter = mAdapter

        getTaskIcons.invoke(category, mAdapter)
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemRvTaskBinding.inflate(layoutInflater, parent, attachToParent)

    companion object {
        fun createInstance(
            getTaskIcons: (String, TaskIconRvAdapter) -> Unit,
            taskSelected: (Icon) -> Unit
        ) = RvTaskAdapter(getTaskIcons, taskSelected)
    }
}

