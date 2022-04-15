package lostankit7.droid.moodtracker.base.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import lostankit7.droid.databinding.DialogProgressBinding
import lostankit7.droid.moodtracker.utils.DialogHelper
import lostankit7.droid.moodtracker.utils.showSnackBar
import lostankit7.droid.moodtracker.utils.showToast
import lostankit7.droid.moodtracker.ui.MainActivity

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    lateinit var binding: VB

    lateinit var navController: NavController

    val TAG by lazy { javaClass.simpleName }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = inflateLayout(layoutInflater)
        onCreateView()
        return binding.root
    }

    abstract fun inflateLayout(layoutInflater: LayoutInflater): VB
    open fun onCreateView() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")
        navController = Navigation.findNavController(view)

        init()
        initRecyclerView()
        initListeners()
        lifecycleScope.launchWhenStarted { registerObservers() }
    }

    open fun init() {}
    open fun initRecyclerView() {}
    open suspend fun registerObservers() {}
    open fun initListeners() {}

    fun navigateTo(directions: NavDirections) {
        findNavController().navigate(directions)
    }

    protected fun navigateTo(id: Int) {
        navController.navigate(id)
    }

    protected fun navigateTo(id: Int, bundle: Bundle) {
        navController.navigate(id, bundle)
    }

}