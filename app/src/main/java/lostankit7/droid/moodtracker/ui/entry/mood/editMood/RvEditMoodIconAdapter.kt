package lostankit7.droid.moodtracker.ui.entry.mood.editMood

import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.databinding.ItemEditMoodIconBinding
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.helper.constant.Action.DELETE
import lostankit7.droid.moodtracker.helper.constant.Action.EDIT

class RvEditMoodIconAdapter(private val onClick: (Int, MoodIcon) -> Unit) :
    BaseDiffRvAdapter<ItemEditMoodIconBinding, MoodIcon>() {

    override fun bindViewHolder(item: MoodIcon, position: Int, binding: ItemEditMoodIconBinding) {
        binding.tvMoodName.text = item.name
        binding.moodIcon.text = item.icon

        binding.root.setOnClickListener { onClick(EDIT, item) }
        binding.tvEditMood.setOnClickListener { onClick(EDIT, item) }
        binding.tvDeleteMood.setOnClickListener { onClick(DELETE, item) }
    }
//todo add ripple effect on root view click
    override fun inflateLayout(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ) = ItemEditMoodIconBinding.inflate(layoutInflater)

    companion object {
        fun newInstance(onClick: (Int, MoodIcon) -> Unit) = RvEditMoodIconAdapter(onClick)
    }
}