package lostankit7.android.entry_presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.android.entry_presentation.databinding.ItemRvSuggestedMoodBinding
import lostankit7.droid.moodtracker.core.domain.entities.shared.BaseIcon
import lostankit7.droid.moodtracker.core.presentation.base.adapter.BaseDiffRvAdapter

class MoodIconRvAdapter(
    private val iconSelected: (BaseIcon) -> Unit,
) : BaseDiffRvAdapter<ItemRvSuggestedMoodBinding, BaseIcon>() {

    override fun bindViewHolder(
        item: BaseIcon, position: Int, binding: ItemRvSuggestedMoodBinding
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
        fun newInstance(iconSelected: (BaseIcon) -> Unit) =
            MoodIconRvAdapter(iconSelected)
    }
}