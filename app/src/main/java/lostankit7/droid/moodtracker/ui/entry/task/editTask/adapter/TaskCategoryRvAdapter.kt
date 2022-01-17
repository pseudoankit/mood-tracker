package lostankit7.droid.moodtracker.ui.entry.task.editTask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.databinding.ItemRvSingleTextBinding

class TaskCategoryRvAdapter(private val itemClick: (String) -> Unit) :
    BaseDiffRvAdapter<ItemRvSingleTextBinding, TaskCategory>() {

    override fun onCreateViewHolder(holder: BaseDiffRvAdapter.Companion.ViewHolder<ItemRvSingleTextBinding>) {
        super.onCreateViewHolder(holder)

        holder.binding.root.setOnClickListener {
            itemClick(getItem(holder.adapterPosition).category)
        }

    }

    override fun bindViewHolder(
        item: TaskCategory, position: Int, binding: ItemRvSingleTextBinding
    ) {
        binding.tvText.text = item.category
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemRvSingleTextBinding.inflate(
        layoutInflater,
        parent,
        attachToParent
    )

    companion object {
        fun createInstance(itemClick: (String) -> Unit) = TaskCategoryRvAdapter(itemClick)
    }
}