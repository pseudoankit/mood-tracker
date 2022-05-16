package lostankit7.droid.moodtracker.presentation.adapter

import android.text.SpannableStringBuilder
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.TextView
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.core_presentation.adapter.BaseDiffRvAdapter
import lostankit7.android.entry_domain.entities.UserEntry
import lostankit7.droid.moodtracker.databinding.ItemRvUserEntriesBinding
import lostankit7.droid.moodtracker.core_presentation.utils.DialogHelper
import lostankit7.droid.moodtracker.common.utils.Constants.DB_ENTRY_SEPARATOR
import lostankit7.droid.moodtracker.core_presentation.utils.hide

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
                parent.context, holder.binding.optionMenu, R.menu.menu_options
            ) {
                itemClicked(it, getItem(holder.adapterPosition))
            }
        }
        holder.binding.optionMenu.setOnClickListener { showOptionDialog() }
        holder.binding.root.setOnClickListener { showOptionDialog() }
    }

    override fun bindViewHolder(item: UserEntry, position: Int, binding: ItemRvUserEntriesBinding) {
        val tasks = SpannableStringBuilder()
        val icons = item.taskIcons.split(DB_ENTRY_SEPARATOR)
        val names = item.taskNames.split(DB_ENTRY_SEPARATOR)
        for (i in icons.indices) {
            tasks.append("  |  ${icons[i]} ${names[i]}")
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