package lostankit7.droid.moodtracker.core.presentation.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding

abstract class BaseDiffRvAdapter<VB : ViewBinding, T : Any>(
    areItemsSame: (oldItem: T, newItem: T) -> Boolean = { old, new -> old.toString() == new.toString() },
    areContentsSame: (oldItem: T, newItem: T) -> Boolean = { old, new -> old == new },
) : ListAdapter<T, BaseViewHolder<VB>>(BaseItemCallback<T>(areItemsSame, areContentsSame)) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        val binding = inflateLayout(LayoutInflater.from(parent.context), parent, false)
        val holder = BaseViewHolder(binding)
        onCreateHolder(holder, parent, viewType)
        return holder
    }

    open fun onCreateHolder(holder: BaseViewHolder<VB>, parent: ViewGroup, viewType: Int) {}

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        bindViewHolder(getItem(position), position, holder.binding)
    }

    abstract fun bindViewHolder(item: T, position: Int, binding: VB)
    abstract fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean,
    ): VB
}