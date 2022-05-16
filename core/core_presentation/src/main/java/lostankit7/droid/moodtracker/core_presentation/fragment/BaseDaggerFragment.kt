package lostankit7.droid.moodtracker.core_presentation.fragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import lostankit7.droid.moodtracker.core_presentation.di.viewmodel.ViewModelFactory
import javax.inject.Inject

abstract class BaseDaggerFragment<VB : ViewBinding, VM : ViewModel> : BaseFragment<VB>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel: VM by lazy { initiateViewModel(ViewModelProvider(this, viewModelFactory)) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectFragment()
    }

    abstract fun initiateViewModel(viewModelProvider: ViewModelProvider): VM

    /** Inject fragment here appComponent.inject(this) */
    abstract fun injectFragment()
}
