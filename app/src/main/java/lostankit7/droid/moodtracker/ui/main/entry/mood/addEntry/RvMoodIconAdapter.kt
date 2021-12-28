package lostankit7.droid.moodtracker.ui.main.entry.mood.addEntry

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseRvAdapter
import lostankit7.droid.moodtracker.databinding.ItemRvMoodIconBinding
import lostankit7.droid.moodtracker.helper.hide
import lostankit7.droid.moodtracker.model.Icon

class RvMoodIconAdapter(
    context: Context,
    list: MutableList<Icon>,
    private val iconSelected: (Icon) -> Unit,
    private val type: Int
) : BaseRvAdapter<ItemRvMoodIconBinding, Icon>(list, context) {

    override fun onCreateViewHolder(binding: ItemRvMoodIconBinding) {
        if (type == SUGGESTION_ADAPTER) {
            binding.tvName.hide()
            binding.tvIcon.setTextColor(
                ContextCompat.getColor(context!!, R.color.sec_icon_color)
            )
        }
    }

    override fun bindViewHolder(item: Icon, position: Int, binding: ItemRvMoodIconBinding) {
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
        const val SUGGESTION_ADAPTER = 1
        fun newInstance(
            context: Context,
            list: MutableList<Icon>,
            iconSelected: (Icon) -> Unit,
            type: Int = 0
        ) = RvMoodIconAdapter(context, list, iconSelected, type)
    }
}