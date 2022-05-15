package lostankit7.droid.moodtracker.base.fragment

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
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.core_presentation.databinding.CommonActionBarBinding
import lostankit7.droid.moodtracker.core_presentation.utils.hide
import lostankit7.droid.moodtracker.presentation.MainActivity

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    lateinit var binding: VB
    lateinit var navController: NavController

    val TAG by lazy { javaClass.simpleName }

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
        (activity as? MainActivity)?.actionBar()?.let {
            updateActionBar(it)
        }

        init()
        initRecyclerView()
        initListeners()
        lifecycleScope.launchWhenStarted { registerObservers() }
    }

    open fun init() {}
    open fun initRecyclerView() {}
    open suspend fun registerObservers() {}
    open fun initListeners() {}

    open fun updateActionBar(actionBar: CommonActionBarBinding) {
        actionBar.leftIcon1.text = resources.getString(R.string.fas_circular_back)
        actionBar.root.hide()
    }

    fun navigateTo(directions: NavDirections) {
        findNavController().navigate(directions)
    }
}