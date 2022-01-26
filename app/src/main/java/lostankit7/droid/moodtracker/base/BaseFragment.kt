package lostankit7.droid.moodtracker.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import lostankit7.droid.databinding.DialogProgressBinding
import lostankit7.droid.moodtracker.helper.DialogHelper
import lostankit7.droid.moodtracker.helper.showSnackBar
import lostankit7.droid.moodtracker.helper.showToast
import lostankit7.droid.moodtracker.model.Status
import lostankit7.droid.moodtracker.ui.MainActivity

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    lateinit var binding: VB

    lateinit var navController: NavController
    val actionBar by lazy { (requireActivity() as? MainActivity)?.actionBar() }

    private val progressBinding by lazy { DialogProgressBinding.inflate(layoutInflater) }
    private val progressDialog by lazy { DialogHelper.showDialog(requireActivity(), progressBinding) }

    var TAG = "Activity"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateLayout(layoutInflater)
        TAG = binding.javaClass.simpleName
        onCreateView()
        return binding.root
    }

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

    abstract fun inflateLayout(layoutInflater: LayoutInflater): VB

    fun handleUIState(value: Status) {
        when (value) {
            is Status.Success -> {
                hideProgressDialog()
                if (value.message?.trim()?.isNotEmpty() == true)
                    requireContext().showToast(value.message)
            }
            is Status.Error -> {
                hideProgressDialog()
                if (value.message?.trim()?.isNotEmpty() == true)
                    requireActivity().showSnackBar(value.message)
            }
            is Status.Loading -> showProgressDialog()
            else -> ""
        }
    }

    fun showProgressDialog(text: String = "Loading...") {
        progressBinding.tvProgressText.text = text
        progressDialog.show()
    }

    fun hideProgressDialog() {
        if (progressDialog.isShowing)
            progressDialog.dismiss()
    }

    protected fun navigateTo(id: Int) {
        navController.navigate(id)
    }

    protected fun navigateTo(id: Int, bundle: Bundle) {
        navController.navigate(id, bundle)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

}