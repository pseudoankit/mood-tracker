package lostankit7.android.entry_presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import lostankit7.android.entry_domain.entities.TaskIcon
import lostankit7.android.entry_presentation.R
import lostankit7.android.entry_presentation.databinding.ItemRvTaskIconBinding
import lostankit7.droid.CustomTextView
import lostankit7.droid.moodtracker.core.domain.entities.shared.BaseIcon
import lostankit7.droid.moodtracker.core.presentation.base.adapter.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.core.presentation.utils.ViewExt.invert

class TaskIconRvAdapter(
    private val taskSelected: (BaseIcon) -> Unit, private val isMultiSelect: Boolean
) : BaseDiffRvAdapter<ItemRvTaskIconBinding, BaseIcon>() {

    override fun bindViewHolder(item: BaseIcon, position: Int, binding: ItemRvTaskIconBinding) {

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
        fun newInstance(taskSelected: (BaseIcon) -> Unit, isMultiSelect: Boolean) =
            TaskIconRvAdapter(taskSelected, isMultiSelect)
    }
}