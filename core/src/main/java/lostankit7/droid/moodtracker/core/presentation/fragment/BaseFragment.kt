package lostankit7.droid.moodtracker.core.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    lateinit var binding: VB
    lateinit var navController: NavController

    val TAG: String by lazy { javaClass.simpleName }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        binding = inflateLayout(layoutInflater)
        onCreateView()
        return binding.root
    }

    abstract fun inflateLayout(layoutInflater: LayoutInflater): VB
    open fun onCreateView() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        init()
        updateActionBar()
        initRecyclerView()
        initListeners()
        registerObservers()
    }

    open fun updateActionBar() {}
    open fun init() {}
    open fun initRecyclerView() {}
    open fun registerObservers() {}
    open fun initListeners() {}

    fun navigateTo(directions: NavDirections) {
        findNavController().navigate(directions)
    }
}