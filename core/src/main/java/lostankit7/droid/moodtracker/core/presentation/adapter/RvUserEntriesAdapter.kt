package lostankit7.droid.moodtracker.core.presentation.adapter

import android.text.SpannableStringBuilder
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.TextView
import lostankit7.droid.moodtracker.core.R
import lostankit7.droid.moodtracker.core.databinding.ItemRvUserEntriesBinding
import lostankit7.droid.moodtracker.core.domain.entities.UserEntry
import lostankit7.droid.moodtracker.core.presentation.utils.DialogHelper
import lostankit7.droid.moodtracker.core.presentation.utils.UiUtils.hide

class RvUserEntriesAdapter(
    private val itemClicked: (MenuItem, UserEntry) -> Boolean,
) : BaseDiffRvAdapter<ItemRvUserEntriesBinding, UserEntry>() {

    override fun onCreateHolder(
        holder: BaseDiffRvAdapter.Companion.ViewHolder<ItemRvUserEntriesBinding>,
        parent: ViewGroup,
        viewType: Int
    ) {
        super.onCreateHolder(holder, parent, viewType)

        fun showOptionDialog() {
            DialogHelper.showMenu(
                parent.context, holder.binding.optionMenu, R.menu.menu_options_item_user_entries
            ) {
                itemClicked(it, getItem(holder.adapterPosition))
            }
        }
        holder.binding.optionMenu.setOnClickListener { showOptionDialog() }
        holder.binding.root.setOnClickListener { showOptionDialog() }
    }

    override fun bindViewHolder(item: UserEntry, position: Int, binding: ItemRvUserEntriesBinding) {
        val tasks = SpannableStringBuilder()
        val icons = item.taskIcons
        for (i in icons.indices) {
            tasks.append("  |  ${icons[i].icon} ${icons[i].name}")
        }
        binding.apply {
            tvTasks.gravity = Gravity.START
            tvDate.text(item.date)
            tvTime.text(item.time)
            tvMoodIcon.text(item.moodIcon)
            tvMoodName.text(item.moodName)
            tvTasks.text(tasks.substring(4))
            tvNote.text(item.note)
        }
    }

    private fun TextView.text(it: String) {
        if (it.isBlank()) hide()
        else text = it
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemRvUserEntriesBinding.inflate(layoutInflater, parent, false)

    companion object {
        fun newInstance(itemClicked: (MenuItem, UserEntry) -> Boolean) =
            RvUserEntriesAdapter(itemClicked)
    }
}