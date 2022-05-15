package lostankit7.droid.moodtracker.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import lostankit7.droid.CustomTextView
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.core_presentation.adapter.BaseDiffRvAdapter
import lostankit7.android.entry_data.database.entities.Icon
import lostankit7.android.entry_data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.databinding.ItemRvTaskIconBinding
import lostankit7.droid.moodtracker.core_presentation.utils.invert

class TaskIconRvAdapter(
    private val taskSelected: (lostankit7.android.entry_data.database.entities.Icon) -> Unit, private val isMultiSelect: Boolean
) : BaseDiffRvAdapter<ItemRvTaskIconBinding, lostankit7.android.entry_data.database.entities.Icon>() {

    override fun bindViewHolder(item: lostankit7.android.entry_data.database.entities.Icon, position: Int, binding: ItemRvTaskIconBinding) {

        if (item.isSolid) binding.tvIcon.isSolidIcon() else binding.tvIcon.isRegularIcon()
        binding.tvName.invert(item is lostankit7.android.entry_data.database.entities.TaskIcon)
        binding.tvIcon
            .setTextColor(ContextCompat.getColor(binding.tvIcon.context, R.color.sec_icon_color))
        binding.tvName
            .setTextColor(ContextCompat.getColor(binding.tvName.context, R.color.sec_icon_color))

        binding.tvName.text = item.name
        binding.tvIcon.text = item.icon
        if (isMultiSelect && item is lostankit7.android.entry_data.database.entities.TaskIcon) {
            binding.tvIcon.updateSelection(item.isSelected)
        }

        binding.root.setOnClickListener {
            taskSelected.invoke(item)

            if (isMultiSelect && item is lostankit7.android.entry_data.database.entities.TaskIcon) {
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
        fun newInstance(taskSelected: (lostankit7.android.entry_data.database.entities.Icon) -> Unit, isMultiSelect: Boolean) =
            TaskIconRvAdapter(taskSelected, isMultiSelect)
    }
}