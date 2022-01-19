package lostankit7.droid.moodtracker.ui.adapter

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon
import lostankit7.droid.moodtracker.databinding.ItemIconListBinding
import lostankit7.droid.moodtracker.helper.DialogHelper
import lostankit7.droid.moodtracker.helper.constant.Action.EDIT

class IconListRvAdapter(
    private val itemClick: (Any) -> Unit,
    private val optionsSelected: (MenuItem,Any) -> Boolean
) : BaseDiffRvAdapter<ItemIconListBinding, Any>() {

    override fun onCreateHolder(
        holder: BaseDiffRvAdapter.Companion.ViewHolder<ItemIconListBinding>,
        parent: ViewGroup, viewType: Int
    ) {
        super.onCreateHolder(holder, parent, viewType)

        holder.binding.root.setOnClickListener { itemClick(getItem(holder.adapterPosition)) }
        holder.binding.optionMenu.setOnClickListener {
            DialogHelper.showMenu(
                parent.context, holder.binding.optionMenu, R.menu.menu_options
            ) { optionsSelected(it,getItem(holder.adapterPosition)) }
        }
    }

    override fun bindViewHolder(item: Any, position: Int, binding: ItemIconListBinding) {
        when (item) {
            is MoodIcon -> {
                binding.faIcon.isRegularIcon()
                binding.tvName.text = item.name
                binding.faIcon.text = item.icon
            }
            is TaskIcon -> {
                binding.faIcon.isSolidIcon()
                binding.tvName.text = item.name
                binding.faIcon.text = item.icon
            }
        }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemIconListBinding.inflate(layoutInflater, parent, attachToParent)

    companion object {
        fun newInstance(onClick: (Any) -> Unit, optionsSelected: (MenuItem,Any) -> Boolean) =
            IconListRvAdapter(onClick, optionsSelected)
    }
}