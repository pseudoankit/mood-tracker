package lostankit7.droid.moodtracker.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lostankit7.droid.moodtracker.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        val myNavHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
//        val inflater = myNavHostFragment.navController.navInflater
//        val graph = inflater.inflate(R.navigation.nav_graph)
//        myNavHostFragment.navController.graph = graph

//        (binding.)
//        val inflater = findViewById<NavHostFragment>(R.id.fragment_container).navController.navInflater
//        val graph = inflater.inflate(R.navigation.my_nav_graph)
//        myNavHostFragment.navController.graph = graph
//        binding.fragmentContainer.findNavController().navInflater.inflate(R.navigation.nav_graph)
    }
}