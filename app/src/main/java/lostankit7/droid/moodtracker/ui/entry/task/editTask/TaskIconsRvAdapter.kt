package lostankit7.droid.moodtracker.ui.entry.task.editTask

import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.databinding.ItemIconListBinding
import lostankit7.droid.moodtracker.helper.constant.Action.DELETE
import lostankit7.droid.moodtracker.helper.constant.Action.EDIT

class TaskIconsRvAdapter(private val onClick: (Int, TaskIcon) -> Unit) :
    BaseDiffRvAdapter<ItemIconListBinding, TaskIcon>() {

    override fun onCreateViewHolder(holder: BaseDiffRvAdapter.Companion.ViewHolder<ItemIconListBinding>) {
        super.onCreateViewHolder(holder)

        holder.binding.moodIcon.isSolidIcon()
    }

    override fun bindViewHolder(item: TaskIcon, position: Int, binding: ItemIconListBinding) {
        binding.tvMoodName.text = item.name
        binding.moodIcon.text = item.icon

        binding.root.setOnClickListener { onClick(EDIT, item) }
        binding.tvEditMood.setOnClickListener { onClick(EDIT, item) }
        binding.tvDeleteMood.setOnClickListener { onClick(DELETE, item) }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemIconListBinding.inflate(layoutInflater, parent, attachToParent)

    companion object {
        fun newInstance(onClick: (Int, TaskIcon) -> Unit) = TaskIconsRvAdapter(onClick)
    }
}