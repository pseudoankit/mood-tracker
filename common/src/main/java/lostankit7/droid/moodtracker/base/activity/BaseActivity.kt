package lostankit7.droid.moodtracker.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VM : ViewModel, VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM
    protected var TAG = "Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateLayout(layoutInflater)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
        ).get(viewModel())
        TAG = binding.javaClass.simpleName
        setContentView(binding.root)
    }

    abstract fun inflateLayout(layoutInflater: LayoutInflater): VB
    abstract fun viewModel(): Class<VM>
}