package lostankit7.droid.moodtracker.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.base.adapter.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.data.database.entities.Suggestion
import lostankit7.droid.moodtracker.databinding.ItemTextChipsBinding

class TextRvAdapter(private val itemClick: (Suggestion) -> Unit) :
    BaseDiffRvAdapter<ItemTextChipsBinding, Suggestion>() {

    override fun onCreateHolder(
        holder: BaseDiffRvAdapter.Companion.ViewHolder<ItemTextChipsBinding>,
        parent: ViewGroup, viewType: Int
    ) {
        super.onCreateHolder(holder, parent, viewType)
        holder.binding.root.setOnClickListener { itemClick(getItem(holder.adapterPosition)) }
    }

    override fun bindViewHolder(item: Suggestion, position: Int, binding: ItemTextChipsBinding) {
        binding.tvName.text = item.name
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemTextChipsBinding.inflate(layoutInflater,parent, attachToParent)

    companion object {
        fun createInstance(itemClick: (Suggestion) -> Unit) = TextRvAdapter(itemClick)
    }
}