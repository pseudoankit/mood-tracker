package lostankit7.droid.moodtracker.core.presentation.base.adapter

import androidx.recyclerview.widget.DiffUtil

class BaseItemCallback<T : Any>(
    private val areItemsSame: (oldItem: T, newItem: T) -> Boolean,
    private val areContentsSame: (oldItem: T, newItem: T) -> Boolean,
) : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return this.areItemsSame(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return areContentsSame(oldItem, newItem)
    }
}