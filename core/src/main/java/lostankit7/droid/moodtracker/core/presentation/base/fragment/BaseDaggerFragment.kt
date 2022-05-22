package lostankit7.droid.moodtracker.core.presentation.base.fragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import lostankit7.droid.moodtracker.core.MyApplication
import lostankit7.droid.moodtracker.core.di.viewmodel.ViewModelFactory
import javax.inject.Inject

abstract class BaseDaggerFragment<VB : ViewBinding, VM : ViewModel> : BaseFragment<VB>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel: VM by lazy(LazyThreadSafetyMode.NONE) { initiateViewModel(ViewModelProvider(this, viewModelFactory)) }

    val coreAppComponent by lazy(LazyThreadSafetyMode.NONE) { (activity?.application as MyApplication).coreAppComponent }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectFragment()
    }

    abstract fun initiateViewModel(viewModelProvider: ViewModelProvider): VM

    /** Inject fragment here appComponent.inject(this) */
    abstract fun injectFragment()
}
