package lostankit7.droid.moodtracker.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.base.adapter.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.databinding.ItemRvMoodIconBinding
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon

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