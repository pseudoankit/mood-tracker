package lostankit7.droid.moodtracker.core.presentation.base.adapter

import androidx.recyclerview.widget.DiffUtil

class BaseDiffCallback<T>(
    private val oldList: List<T>,
    private val newList: List<T>,
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}