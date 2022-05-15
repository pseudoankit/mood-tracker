package lostankit7.droid.moodtracker.presentation.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.databinding.FragmentMoreBinding
import lostankit7.droid.moodtracker.presentation.viewmodel.MoreViewModel
import lostankit7.droid.moodtracker.common.utils.hide
import lostankit7.droid.moodtracker.common.utils.hideKeyBoard
import lostankit7.droid.moodtracker.common.utils.show

class MoreFragment : BaseDaggerFragment<FragmentMoreBinding, MoreViewModel>() {

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

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[MoreViewModel::class.java]

    override fun injectFragment() {
        DaggerAppComponent
            .builder()
            .baseComponent(InjectUtils.provideBaseComponent(
                activity?.applicationContext ?: error(""))
            ).build()
            .inject(this)
    }

}