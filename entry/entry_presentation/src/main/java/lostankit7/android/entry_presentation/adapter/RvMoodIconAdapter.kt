package lostankit7.android.entry_presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.core_presentation.adapter.BaseDiffRvAdapter
import lostankit7.android.entry_domain.entities.MoodIcon
import lostankit7.android.entry_presentation.databinding.ItemRvMoodIconBinding

class RvMoodIconAdapter(
    private val context: Context?,
    private val iconSelected: (MoodIcon) -> Unit
) : BaseDiffRvAdapter<ItemRvMoodIconBinding, MoodIcon>() {

    override fun bindViewHolder(item: MoodIcon, position: Int, binding: ItemRvMoodIconBinding) {
        binding.tvName.text = item.name
        binding.tvIcon.text = item.icon

        binding.root.setOnClickListener {
            iconSelected.invoke(item)
        }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemRvMoodIconBinding.inflate(layoutInflater, parent, attachToParent)

}