package lostankit7.droid.moodtracker.base.fragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import lostankit7.droid.moodtracker.MyApplication
import lostankit7.droid.moodtracker.base.factory.ViewModelFactory
import lostankit7.droid.moodtracker.di.AppComponent
import javax.inject.Inject

abstract class BaseDaggerFragment<VB : ViewBinding, VM : ViewModel> : BaseFragment<VB>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel: VM by lazy { initiateViewModel(ViewModelProvider(this, viewModelFactory)) }

    val appComponent by lazy { (requireActivity().application as MyApplication).appComponent }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectFragment(appComponent)
    }

    abstract fun initiateViewModel(viewModelProvider: ViewModelProvider): VM

    /** Inject fragment here appComponent.inject(this) */
    abstract fun injectFragment(appComponent: AppComponent)
}
