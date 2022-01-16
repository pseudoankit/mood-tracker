package lostankit7.droid.moodtracker.ui.entry.task.addTask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.databinding.ItemRvTaskIconBinding

class RvTaskItemAdapter(
    private val taskSelected: (TaskIcon) -> Unit
) : BaseDiffRvAdapter<ItemRvTaskIconBinding, TaskIcon>() {

    override fun bindViewHolder(item: TaskIcon, position: Int, binding: ItemRvTaskIconBinding) {
        binding.tvName.text = item.name
        binding.tvIcon.text = item.icon

        binding.root.setOnClickListener {
            item.isSelected = !item.isSelected
            binding.tvIcon.apply {
                taskSelected.invoke(item)
                if (item.isSelected) {
                    setTextColor(ContextCompat.getColor(context, R.color.task_icon_bg))
                    solidColor(ContextCompat.getColor(context, R.color.task_icon))
                } else {
                    setTextColor(ContextCompat.getColor(context, R.color.task_icon))
                    solidColor(ContextCompat.getColor(context, R.color.task_icon_bg))
                }
            }
        }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemRvTaskIconBinding.inflate(layoutInflater, parent, attachToParent)

    companion object {
        fun newInstance(taskSelected: (TaskIcon) -> Unit) = RvTaskItemAdapter(taskSelected)
    }
}