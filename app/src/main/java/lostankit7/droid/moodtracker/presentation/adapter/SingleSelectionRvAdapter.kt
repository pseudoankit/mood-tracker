package lostankit7.droid.moodtracker.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.core_presentation.adapter.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.databinding.ItemRvSingleSelectionBinding
import lostankit7.droid.moodtracker.common.domain.entities.SingleSelectionModel

class SingleSelectionRvAdapter(private val context: Context) :
    BaseDiffRvAdapter<ItemRvSingleSelectionBinding, SingleSelectionModel>() {
    override fun bindViewHolder(
        item: SingleSelectionModel,
        position: Int,
        binding: ItemRvSingleSelectionBinding
    ) {

        binding.txtTitle.text = item.title
        binding.faIconSelected.text =
            context.resources.getString(if (item.isSelected) R.string.fas_circular_tick else R.string.far_circle)

    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemRvSingleSelectionBinding.inflate(layoutInflater, parent, attachToParent)

    companion object {
        fun createInstance(context: Context) = SingleSelectionRvAdapter(context)
    }
}