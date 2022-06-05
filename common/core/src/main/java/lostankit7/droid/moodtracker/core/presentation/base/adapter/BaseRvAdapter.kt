package lostankit7.droid.moodtracker.core.presentation.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRvAdapter<VB : ViewBinding, T : Any>(
    val mList: MutableList<T> = mutableListOf(),
    val context: Context? = null,
) : RecyclerView.Adapter<BaseViewHolder<VB>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        val binding = inflateLayout(LayoutInflater.from(parent.context), parent, false)
        val holder = BaseViewHolder(binding)
        onCreateHolder(holder, parent, viewType)
        return holder
    }

    open fun onCreateHolder(holder: BaseViewHolder<VB>, parent: ViewGroup, viewType: Int) {}

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        bindViewHolder(mList[position], position, holder.binding)
    }

    override fun getItemCount() = mList.size

    abstract fun bindViewHolder(item: T, position: Int, binding: VB)
    abstract fun inflateLayout(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean,
    ): VB
}