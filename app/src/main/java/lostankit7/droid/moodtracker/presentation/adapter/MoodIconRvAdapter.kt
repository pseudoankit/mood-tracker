package lostankit7.droid.moodtracker.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.core_presentation.adapter.BaseDiffRvAdapter
import lostankit7.android.entry_data.database.entities.Icon
import lostankit7.droid.moodtracker.databinding.ItemRvSuggestedMoodBinding

class MoodIconRvAdapter(
    private val iconSelected: (lostankit7.android.entry_data.database.entities.Icon) -> Unit,
) : BaseDiffRvAdapter<ItemRvSuggestedMoodBinding, lostankit7.android.entry_data.database.entities.Icon>() {

    override fun bindViewHolder(
        item: lostankit7.android.entry_data.database.entities.Icon, position: Int, binding: ItemRvSuggestedMoodBinding
    ) {
        if(item.isSolid) binding.tvIcon.isSolidIcon() else binding.tvIcon.isRegularIcon()
        binding.tvIcon.text = item.icon
        binding.root.setOnClickListener {
            iconSelected.invoke(item)
        }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemRvSuggestedMoodBinding.inflate(layoutInflater,parent, attachToParent)

    companion object {
        fun newInstance(iconSelected: (lostankit7.android.entry_data.database.entities.Icon) -> Unit) =
            MoodIconRvAdapter(iconSelected)
    }
}