package lostankit7.droid.moodtracker.ui.main.userEntries

import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import lostankit7.droid.moodtracker.databinding.ItemRvUserEntriesBinding
import lostankit7.droid.moodtracker.helper.constant.Constants
import lostankit7.droid.moodtracker.helper.constant.FontAwesomeIcon

class RvUserEntriesAdapter(private val itemClicked: (UserEntry) -> Unit) :
    BaseDiffRvAdapter<ItemRvUserEntriesBinding, UserEntry>(
        Companion::areItemsTheSame,
        Companion::areContentsTheSame
    ) {

    override fun bindViewHolder(item: UserEntry, position: Int, binding: ItemRvUserEntriesBinding) {
        val tasks = SpannableStringBuilder()
        val icons = item.taskIcons.split(Constants.dbEntrySeparator)
        val names = item.taskNames.split(Constants.dbEntrySeparator)
        for (i in icons.indices) {
            //todo correct it
            tasks.append("${FontAwesomeIcon.dot} ${icons[i]}  ${names[i]} ")
        }
        binding.apply {
            tvDate.text = item.date
            tvTime.text = item.time
            tvMoodIcon.text = item.moodIcon
            tvMoodName.text = item.moodName
            tvTasks.text = tasks.substring(2)

        }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ) = ItemRvUserEntriesBinding.inflate(layoutInflater, parent, false)

    companion object {
        private fun areItemsTheSame(oldItem: UserEntry, newItem: UserEntry): Boolean {
            return oldItem.date == newItem.date && oldItem.time == newItem.time
        }

        private fun areContentsTheSame(oldItem: UserEntry, newItem: UserEntry): Boolean {
            return oldItem == newItem
        }

        fun newInstance(itemClicked: (UserEntry) -> Unit) = RvUserEntriesAdapter(itemClicked)
    }
}