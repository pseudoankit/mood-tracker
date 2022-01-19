package lostankit7.droid.moodtracker.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.Icon
import lostankit7.droid.moodtracker.databinding.ItemRvSuggestedMoodBinding

class DisplayIconRvAdapter(
    private val iconSelected: (Icon) -> Unit,
) : BaseDiffRvAdapter<ItemRvSuggestedMoodBinding, Icon>() {

    override fun bindViewHolder(
        item: Icon, position: Int, binding: ItemRvSuggestedMoodBinding
    ) {
        binding.tvIcon.text = item.icon
        binding.root.setOnClickListener {
            iconSelected.invoke(item)
        }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemRvSuggestedMoodBinding.inflate(layoutInflater)

    companion object {
        fun newInstance(iconSelected: (Icon) -> Unit) =
            DisplayIconRvAdapter(iconSelected)
    }
}