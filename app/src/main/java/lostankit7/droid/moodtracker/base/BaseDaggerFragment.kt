package lostankit7.droid.moodtracker.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import lostankit7.droid.databinding.DialogProgressBinding
import lostankit7.droid.moodtracker.helper.inflateDialog
import lostankit7.droid.moodtracker.helper.showSnackBar
import lostankit7.droid.moodtracker.helper.showToast
import lostankit7.droid.moodtracker.model.Status
import javax.inject.Inject

abstract class BaseDaggerFragment<VB : ViewBinding, VM : ViewModel> : Fragment() {

    @Inject
    lateinit var viewModel: VM
    protected lateinit var binding: VB
    lateinit var navController: NavController

    private val progressBinding by lazy { DialogProgressBinding.inflate(layoutInflater) }
    private val progressDialog by lazy { requireActivity().inflateDialog(progressBinding.root) }
    var TAG = "Activity"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectFragment()
    }

    /** Inject fragment here (application as MyApplication).appComponent.inject(this) */
    abstract fun injectFragment()

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
        if (actionBarTitle().isNotEmpty())
            (requireActivity() as? AppCompatActivity)?.supportActionBar?.title = actionBarTitle()

        init()
        lifecycleScope.launchWhenStarted {
            registerObservers()
        }
        initListeners()
    }

    open fun init() {}
    open fun initListeners() {}
    open suspend fun registerObservers() {}

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
        }
    }

    protected fun showProgressDialog(text: String = "Loading...") {
        progressBinding.tvProgressText.text = text
        progressDialog.show()
    }

    protected fun hideProgressDialog() {
        if (progressDialog.isShowing)
            progressDialog.dismiss()
    }

    open fun actionBarTitle() = ""
    abstract fun inflateLayout(layoutInflater: LayoutInflater): VB
    abstract fun viewModel(): Class<VM>
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
