package lostankit7.droid.moodtracker.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import lostankit7.droid.CustomTextView
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.databinding.ItemRvTaskIconBinding
import lostankit7.droid.moodtracker.helper.invert

class TaskIconRvAdapter(
    private val taskSelected: (Icon) -> Unit, private val isMultiSelect: Boolean
) : BaseDiffRvAdapter<ItemRvTaskIconBinding, Icon>() {

    override fun bindViewHolder(item: Icon, position: Int, binding: ItemRvTaskIconBinding) {

        if (item.isSolid) binding.tvIcon.isSolidIcon() else binding.tvIcon.isRegularIcon()
        binding.tvName.invert(item is TaskIcon)
        binding.tvIcon
            .setTextColor(ContextCompat.getColor(binding.tvIcon.context, R.color.sec_icon_color))
        binding.tvName
            .setTextColor(ContextCompat.getColor(binding.tvName.context, R.color.sec_icon_color))

        binding.tvName.text = item.name
        binding.tvIcon.text = item.icon
        if (isMultiSelect && item is TaskIcon) {
            binding.tvIcon.updateSelection(item.isSelected)
        }

        binding.root.setOnClickListener {
            taskSelected.invoke(item)

            if (isMultiSelect && item is TaskIcon) {
                item.isSelected = !item.isSelected
                binding.tvIcon.updateSelection(item.isSelected)
            }
        }
    }

    private fun CustomTextView.updateSelection(isSelected: Boolean) {
        if (isSelected) {
            setTextColor(ContextCompat.getColor(context, R.color.task_icon_bg))
            solidColor(ContextCompat.getColor(context, R.color.task_icon))
        } else {
            setTextColor(ContextCompat.getColor(context, R.color.task_icon))
            solidColor(ContextCompat.getColor(context, R.color.task_icon_bg))
        }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemRvTaskIconBinding.inflate(layoutInflater, parent, attachToParent)

    companion object {
        fun newInstance(taskSelected: (Icon) -> Unit, isMultiSelect: Boolean) =
            TaskIconRvAdapter(taskSelected, isMultiSelect)
    }
}