package lostankit7.droid.moodtracker.presentation.adapter

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.core_presentation.adapter.BaseDiffRvAdapter
import lostankit7.android.entry_data.database.entities.Icon
import lostankit7.android.entry_data.database.entities.MoodIcon
import lostankit7.android.entry_data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.databinding.ItemIconListBinding
import lostankit7.droid.moodtracker.core_presentation.utils.DialogHelper

class IconListRvAdapter(
    private val itemClick: (lostankit7.android.entry_data.database.entities.Icon) -> Unit,
    private val optionsSelected: (MenuItem, lostankit7.android.entry_data.database.entities.Icon) -> Boolean
) : BaseDiffRvAdapter<ItemIconListBinding, lostankit7.android.entry_data.database.entities.Icon>() {

    override fun onCreateHolder(
        holder: BaseDiffRvAdapter.Companion.ViewHolder<ItemIconListBinding>,
        parent: ViewGroup, viewType: Int
    ) {
        super.onCreateHolder(holder, parent, viewType)

        holder.binding.root.setOnClickListener { itemClick(getItem(holder.adapterPosition)) }
        holder.binding.optionMenu.setOnClickListener {
            DialogHelper.showMenu(
                parent.context, holder.binding.optionMenu, R.menu.menu_options
            ) { optionsSelected(it, getItem(holder.adapterPosition)) }
        }
    }

    override fun bindViewHolder(item: lostankit7.android.entry_data.database.entities.Icon, position: Int, binding: ItemIconListBinding) {

        if (item.isSolid) binding.faIcon.isSolidIcon() else binding.faIcon.isRegularIcon()
        binding.tvName.text = item.name
        binding.faIcon.text = item.icon

        when (item) {
            is lostankit7.android.entry_data.database.entities.MoodIcon -> {
                binding.faIcon.isRegularIcon()
            }
            is lostankit7.android.entry_data.database.entities.TaskIcon -> {
                binding.faIcon.isSolidIcon()
            }
        }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemIconListBinding.inflate(layoutInflater, parent, attachToParent)

}