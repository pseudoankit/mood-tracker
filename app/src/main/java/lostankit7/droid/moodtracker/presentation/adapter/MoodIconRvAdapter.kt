package lostankit7.droid.moodtracker.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.core_presentation.adapter.BaseDiffRvAdapter
import lostankit7.android.entry_domain.entities.Icon
import lostankit7.droid.moodtracker.databinding.ItemRvSuggestedMoodBinding

class MoodIconRvAdapter(
    private val iconSelected: (Icon) -> Unit,
) : BaseDiffRvAdapter<ItemRvSuggestedMoodBinding, Icon>() {

    override fun bindViewHolder(
        item: Icon, position: Int, binding: ItemRvSuggestedMoodBinding
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
        fun newInstance(iconSelected: (Icon) -> Unit) =
            MoodIconRvAdapter(iconSelected)
    }
}