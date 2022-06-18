package lostankit7.droid.moodtracker.home.presentation

import android.view.LayoutInflater
import androidx.navigation.ui.setupWithNavController
import lostankit7.droid.moodtracker.core.presentation.base.fragment.BaseFragment
import lostankit7.droid.moodtracker.core.presentation.utils.findNavHost
import lostankit7.droid.moodtracker.core.presentation.utils.findRootNavHost
import lostankit7.droid.moodtracker.home.R
import lostankit7.droid.moodtracker.home.databinding.FragmentHomeHostBinding

class HomeHostFragment : BaseFragment<FragmentHomeHostBinding>() {

    override fun init() {
        navController = findNavHost(binding.fragmentContainerHome.id)

        setUpBottomNavigation()
    }

    override fun initListeners() {
        binding.fabAddUserEntry.setOnClickListener {
            findRootNavHost?.navigate(R.id.nav_graph_add_user_entry_host)
        }
    }

    private fun setUpBottomNavigation() {
        with(binding.bottomNavView) {
            background = null
            menu.getItem(2).isEnabled = false
            setupWithNavController(navController)
        }
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentHomeHostBinding.inflate(layoutInflater)
}