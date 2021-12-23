package lostankit7.droid.moodtracker.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import lostankit7.droid.databinding.DialogProgressBinding
import lostankit7.droid.helper.inflateDialog
import lostankit7.droid.moodtracker.helper.showSnackBar
import lostankit7.droid.moodtracker.helper.showToast
import lostankit7.droid.moodtracker.model.Status

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel> : Fragment() {

    lateinit var viewModel: VM
    protected lateinit var binding: VB
    protected lateinit var navController: NavController

    private val progressBinding by lazy { DialogProgressBinding.inflate(layoutInflater) }
    private val progressDialog by lazy { requireActivity().inflateDialog(progressBinding.root) }
    protected var TAG = "Activity"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateLayout(layoutInflater)
        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        ).get(viewModel())
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

    open suspend fun registerObservers() {
        //todo observe stateflow of base view model which will be common for all frags
        /*if (viewModel is BaseViewModel) {
            (viewModel as BaseViewModel).apply {
                this.uiStatus.collect {
                    handleUIState(it)
                }
            }
        }*/
    }

    fun handleUIState(value: Status) {
        when (value) {
            is Status.Success -> {
                hideProgressDialog()
                if (value.message?.trim()?.isNotEmpty() == true)
                    requireContext().showToast(value.message!!)
            }
            is Status.Error -> {
                hideProgressDialog()
                if (value.message?.trim()?.isNotEmpty() == true)
                    requireActivity().showSnackBar(value.message!!)
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

    protected fun getText(txt: EditText) = txt.text.toString().trim()

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
