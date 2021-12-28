package lostankit7.droid.moodtracker.ui.main.entry.mood.editMood

import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.base.BaseRvAdapter
import lostankit7.droid.moodtracker.databinding.ItemEditMoodIconBinding
import lostankit7.droid.moodtracker.model.Icon

class RvEditMoodIconAdapter(list: MutableList<Icon>) :
    BaseRvAdapter<ItemEditMoodIconBinding, Icon>(list) {
    override fun bindViewHolder(item: Icon, position: Int, binding: ItemEditMoodIconBinding) {
        binding.tvMoodName.text = item.name
        binding.moodIcon.text = item.icon
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ) = ItemEditMoodIconBinding.inflate(layoutInflater)

    companion object {
        fun newInstance(list: MutableList<Icon>) =
            RvEditMoodIconAdapter(list)
    }
}