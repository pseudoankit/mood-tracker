package lostankit7.droid.moodtracker.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import lostankit7.droid.moodtracker.base.BaseDiffRvAdapter.Companion.ViewHolder

abstract class BaseDiffRvAdapter<VB : ViewBinding, T : Any>(
    areItemsSame: (oldItem: T, newItem: T) -> Boolean = { old, new -> old === new },
    areContentsSame: (oldItem: T, newItem: T) -> Boolean = { old, new -> old == new }
) : ListAdapter<T, ViewHolder<VB>>(BaseRvComparator<T>(areItemsSame, areContentsSame)) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<VB> {
        val binding = inflateLayout(LayoutInflater.from(parent.context), parent, false)
        val holder = ViewHolder(binding)
        onCreateViewHolder(holder)
        return holder
    }

    open fun onCreateViewHolder(holder: ViewHolder<VB>) {}

    override fun onBindViewHolder(holder: ViewHolder<VB>, position: Int) {
        bindViewHolder(getItem(position), position, holder.binding)
    }

    abstract fun bindViewHolder(item: T, position: Int, binding: VB)
    abstract fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ): VB

    companion object {
        class ViewHolder<VB : ViewBinding>(val binding: VB) :
            RecyclerView.ViewHolder(binding.root)

        class BaseRvComparator<T : Any>(
            private val areItemsSame: (oldItem: T, newItem: T) -> Boolean,
            private val areContentsSame: (oldItem: T, newItem: T) -> Boolean
        ) : DiffUtil.ItemCallback<T>() {
            override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
                return areItemsSame(oldItem, newItem)
            }

            override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
                return areContentsSame(oldItem, newItem)
            }
        }
    }
}