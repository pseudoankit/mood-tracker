package lostankit7.droid.moodtracker.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.base.BaseRvAdapter
import lostankit7.droid.moodtracker.databinding.ItemRvMoodIconBinding
import lostankit7.droid.moodtracker.model.Icon

class RvMoodIconAdapter(
    context: Context,
    list: MutableList<Icon>,
    private val iconSelected: (Icon) -> Unit
) : BaseRvAdapter<ItemRvMoodIconBinding, Icon>(list, context) {
    override fun bindViewHolder(item: Icon, position: Int, binding: ItemRvMoodIconBinding) {
        binding.tvName.text = item.name
        binding.tvIcon.text = item.icon

        binding.root.setOnClickListener {
            iconSelected.invoke(item)
        }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ) = ItemRvMoodIconBinding.inflate(layoutInflater, parent, attachToParent)

    companion object {
        fun newInstance(context: Context, list: MutableList<Icon>, iconSelected: (Icon) -> Unit) =
            RvMoodIconAdapter(context, list, iconSelected)
    }
}