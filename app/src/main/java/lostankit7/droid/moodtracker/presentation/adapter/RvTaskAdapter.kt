package lostankit7.droid.moodtracker.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.core_presentation.adapter.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.databinding.ItemRvExpandableViewBinding
import lostankit7.droid.moodtracker.core_presentation.utils.Constants
import lostankit7.droid.moodtracker.core_presentation.utils.hide
import lostankit7.droid.moodtracker.core_presentation.utils.show

class RvTaskAdapter(
    private val getTaskIcons: (String, TaskIconRvAdapter) -> Unit,
    private val taskSelected: (Icon) -> Unit
) : BaseDiffRvAdapter<ItemRvExpandableViewBinding, TaskCategory>() {

    override fun bindViewHolder(
        item: TaskCategory, position: Int, binding: ItemRvExpandableViewBinding
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
            tvDropDownIcon.text = this.root.context.resources.getString(R.string.fas_collapse)
            rvItems.show()
        } else {
            tvDropDownIcon.text = this.root.context.resources.getString(R.string.fas_expand)
            rvItems.hide()
        }
    }

    private fun RecyclerView.setUpRecyclerView(category: String) {
        layoutManager = GridLayoutManager(context, Constants.SPAN_COUNT_TASK_RV)

        val mAdapter = TaskIconRvAdapter.newInstance(taskSelected, true)
        adapter = mAdapter

        getTaskIcons.invoke(category, mAdapter)
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemRvExpandableViewBinding.inflate(layoutInflater, parent, attachToParent)
}

