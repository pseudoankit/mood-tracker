package lostankit7.droid.moodtracker.ui.main.entry.mood.addEntry

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.base.BaseRvAdapter
import lostankit7.droid.moodtracker.databinding.ItemRvMoodIconBinding
import lostankit7.droid.moodtracker.helper.hide
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.UserEntry

class RvMoodIconAdapter(
    private val context: Context,
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
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ) = ItemRvMoodIconBinding.inflate(layoutInflater, parent, attachToParent)

    companion object {

        fun newInstance(context: Context, iconSelected: (MoodIcon) -> Unit) =
            RvMoodIconAdapter(context, iconSelected)
    }
}