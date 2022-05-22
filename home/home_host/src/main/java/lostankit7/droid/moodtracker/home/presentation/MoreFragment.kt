package lostankit7.droid.moodtracker.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import lostankit7.droid.helper.hide
import lostankit7.droid.helper.show
import lostankit7.droid.moodtracker.core.presentation.base.fragment.BaseFragment
import lostankit7.droid.moodtracker.core.presentation.utils.ViewExt.hideKeyBoard
import lostankit7.droid.moodtracker.home.R
import lostankit7.droid.moodtracker.home.databinding.FragmentMoreBinding

class MoreFragment : BaseFragment<FragmentMoreBinding>() {

    private var isEditEnabled = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun initListeners() {
        binding.layoutProfile.btnEditProfile.setOnClickListener {
            if (isEditEnabled) saveAndDisableProfileEdit() else enableProfileEdit()
        }
    }

    private fun enableProfileEdit() = with(binding.layoutProfile) {
        isEditEnabled = true
        btnEditProfile.text = resources.getString(R.string.fas_tick)
        rootLayout.apply {
            isClickable = true
            txtUserName.hide()
            edtUserName.show()
        }
    }

    private fun saveAndDisableProfileEdit() = with(binding.layoutProfile) {
        //save profile name to pref
        activity?.hideKeyBoard()
        isEditEnabled = false
        btnEditProfile.text = resources.getString(R.string.fas_edit)
        rootLayout.apply {
            isClickable = false
            txtUserName.show()
            edtUserName.hide()
        }
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentMoreBinding.inflate(layoutInflater)

}