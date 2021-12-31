package lostankit7.droid.moodtracker.ui.userEntries

import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import lostankit7.droid.moodtracker.databinding.ItemRvUserEntriesBinding
import lostankit7.droid.moodtracker.helper.constant.FontAwesomeIcon
import lostankit7.droid.moodtracker.helper.constant.dbEntrySeparator

class RvUserEntriesAdapter(private val itemClicked: (UserEntry) -> Unit) :
    BaseDiffRvAdapter<ItemRvUserEntriesBinding, UserEntry>() {

    override fun bindViewHolder(item: UserEntry, position: Int, binding: ItemRvUserEntriesBinding) {
        val tasks = SpannableStringBuilder()
        val icons = item.taskIcons.split(dbEntrySeparator)
        val names = item.taskNames.split(dbEntrySeparator)
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
            tvNote.text = item.note
        }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ) = ItemRvUserEntriesBinding.inflate(layoutInflater, parent, false)

    companion object {
        fun newInstance(itemClicked: (UserEntry) -> Unit) = RvUserEntriesAdapter(itemClicked)
    }
}