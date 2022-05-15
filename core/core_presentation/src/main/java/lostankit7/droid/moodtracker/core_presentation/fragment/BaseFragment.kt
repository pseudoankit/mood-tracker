package lostankit7.droid.moodtracker.core_presentation.fragment

import android.os.Bundle
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
        initRecyclerView()
        initListeners()
        lifecycleScope.launchWhenStarted { registerObservers() }
    }

    open fun init() {}
    open fun initRecyclerView() {}
    open suspend fun registerObservers() {}
    open fun initListeners() {}

    open fun updateActionBar() {

    }

    fun navigateTo(directions: NavDirections) {
        findNavController().navigate(directions)
    }
}