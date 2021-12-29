package lostankit7.droid.moodtracker.ui.main.entry.mood.editMood

import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.databinding.ItemEditMoodIconBinding
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon

class RvEditMoodIconAdapter() :
    BaseDiffRvAdapter<ItemEditMoodIconBinding, MoodIcon>() {

    override fun bindViewHolder(item: MoodIcon, position: Int, binding: ItemEditMoodIconBinding) {
        binding.tvMoodName.text = item.name
        binding.moodIcon.text = item.icon
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ) = ItemEditMoodIconBinding.inflate(layoutInflater)

    companion object {
        fun newInstance() = RvEditMoodIconAdapter()
    }
}