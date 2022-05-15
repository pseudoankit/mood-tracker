package lostankit7.droid.moodtracker.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.core_presentation.adapter.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.databinding.ItemRvMoodIconBinding
import lostankit7.android.entry_data.database.entities.MoodIcon

class RvMoodIconAdapter(
    private val context: Context?,
    private val iconSelected: (lostankit7.android.entry_data.database.entities.MoodIcon) -> Unit
) : BaseDiffRvAdapter<ItemRvMoodIconBinding, lostankit7.android.entry_data.database.entities.MoodIcon>() {

    override fun bindViewHolder(item: lostankit7.android.entry_data.database.entities.MoodIcon, position: Int, binding: ItemRvMoodIconBinding) {
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