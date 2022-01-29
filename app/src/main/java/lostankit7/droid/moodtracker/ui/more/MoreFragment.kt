package lostankit7.droid.moodtracker.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.BaseFragment
import lostankit7.droid.moodtracker.databinding.FragmentMoreBinding
import lostankit7.droid.moodtracker.model.SingleSelectionModel
import lostankit7.droid.moodtracker.ui.adapter.SingleSelectionRvAdapter

class MoreFragment : BaseFragment<FragmentMoreBinding>() {

    private var isEditEnabled = false
    private val adapter by lazy { SingleSelectionRvAdapter.createInstance(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun initListeners() {
        super.initListeners()

        binding.btnEditProfile.setOnClickListener {
            if (isEditEnabled) disableEditProfile() else enableEditProfile()
        }
    }

    private fun enableEditProfile() {
        isEditEnabled = true
        binding.btnEditProfile.text = resources.getString(R.string.fas_tick)
        binding.userImage.isClickable = true
        binding.edtUserName.isEnabled = true
        binding.edtUserName.background =
            ContextCompat.getDrawable(requireContext(), R.drawable.bg_rounded_white_stroke_gray)
    }

    private fun disableEditProfile() {
        isEditEnabled = false
        binding.btnEditProfile.text = resources.getString(R.string.fas_edit)
        binding.userImage.isClickable = false
        binding.edtUserName.isEnabled = false
        binding.edtUserName.background = null
    }

    override fun init() {
        super.init()

        disableEditProfile()
        binding.changeLanguage.txtTitle.text = resources.getString(R.string.text_change_language)

    }

    override fun initRecyclerView() {
        super.initRecyclerView()

        binding.changeLanguage.rvItems.layoutManager = LinearLayoutManager(requireContext())
        binding.changeLanguage.rvItems.adapter = adapter

        val list = resources.getStringArray(R.array.languages).map {
            SingleSelectionModel(it)
        }

        adapter.submitList(list)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentMoreBinding.inflate(layoutInflater)

}