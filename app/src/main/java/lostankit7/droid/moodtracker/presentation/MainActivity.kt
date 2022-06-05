package lostankit7.droid.moodtracker.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.core.di.viewmodel.ViewModelFactory
import lostankit7.droid.moodtracker.core.utils.Utils.fastLazy
import lostankit7.droid.moodtracker.databinding.ActivityMainBinding
import lostankit7.droid.moodtracker.di.component.AppComponent.Companion.appComponent
import lostankit7.droid.moodtracker.presentation.splash.MainViewModel
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by fastLazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDagger()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        saveDefaultValues()
        inflateGraphToHostContainer()
    }

    private fun saveDefaultValues() {
        viewModel.saveDefaultValues(this)
    }

    private fun injectDagger() {
        appComponent.inject(this)
    }

    private fun inflateGraphToHostContainer() {
        val myNavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_root) as NavHostFragment
        val inflater = myNavHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)
        myNavHostFragment.navController.graph = graph
    }
}