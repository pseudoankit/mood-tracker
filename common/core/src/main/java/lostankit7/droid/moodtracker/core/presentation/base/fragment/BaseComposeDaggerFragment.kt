package lostankit7.droid.moodtracker.core.presentation.base.fragment

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lostankit7.droid.moodtracker.core.di.viewmodel.ViewModelFactory
import javax.inject.Inject

abstract class BaseComposeDaggerFragment<VM : ViewModel> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel: VM by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(this, viewModelFactory).initiateViewModel()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectFragment()
    }

    abstract fun ViewModelProvider.initiateViewModel(): VM

    /** Inject fragment here appComponent.inject(this) */
    abstract fun injectFragment()
}
