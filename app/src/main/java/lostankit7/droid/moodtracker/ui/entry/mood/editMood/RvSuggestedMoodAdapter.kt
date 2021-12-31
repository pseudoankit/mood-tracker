package lostankit7.droid.moodtracker.ui.entry.mood.editMood

import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMood
import lostankit7.droid.moodtracker.databinding.ItemRvSuggestedMoodBinding

class RvSuggestedMoodAdapter(
    private val iconSelected: (SuggestedMood) -> Unit,
) : BaseDiffRvAdapter<ItemRvSuggestedMoodBinding, SuggestedMood>() {

    override fun bindViewHolder(
        item: SuggestedMood,
        position: Int,
        binding: ItemRvSuggestedMoodBinding
    ) {

        binding.tvIcon.text = item.icon
        binding.root.setOnClickListener {
            iconSelected.invoke(item)
        }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ) = ItemRvSuggestedMoodBinding.inflate(layoutInflater)

    companion object {
        fun newInstance(iconSelected: (SuggestedMood) -> Unit) =
            RvSuggestedMoodAdapter(iconSelected)
    }
}