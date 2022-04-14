package lostankit7.droid.moodtracker.base.fragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import lostankit7.droid.moodtracker.MyApplication
import lostankit7.droid.moodtracker.di.AppComponent
import javax.inject.Inject

abstract class BaseDaggerFragment<VB : ViewBinding, VM : ViewModel> : BaseFragment<VB>() {



    @Inject
    lateinit var viewModel: VM

    val appComponent by lazy { (requireActivity().application as MyApplication).appComponent }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectFragment(appComponent)
    }

    /** Inject fragment here appComponent.inject(this) */
    abstract fun injectFragment(appComponent: AppComponent)
}
