package lostankit7.droid.moodtracker.base

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseDaggerFragment<VB : ViewBinding, VM : ViewModel> : BaseFragment<VB>() {

    @Inject
    lateinit var viewModel: VM

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectFragment()
    }

    /** Inject fragment here appComponent.inject(this) */
    abstract fun injectFragment()
}
