package lostankit7.droid.moodtracker.home.presentation

import android.view.LayoutInflater
import androidx.navigation.ui.setupWithNavController
import lostankit7.droid.moodtracker.core.presentation.fragment.BaseFragment
import lostankit7.droid.moodtracker.core.presentation.utils.findNavHost
import lostankit7.droid.moodtracker.home.databinding.FragmentHomeBinding

class HomeHostFragment : BaseFragment<FragmentHomeBinding>() {

    override fun init() {
        navController = findNavHost(binding.fragmentContainerHome.id)

        setUpBottomNavigation()
    }

    override fun initListeners() {
        binding.fabAddUserEntry.setOnClickListener {
//            view?.let { view -> Navigation.findNavController(view).navigate(R.id.addUserEntryHostFragment) }
//            activity?.let { activity ->
//                navController.graph.parent?.startDestinationId?.let { it1 ->
//                    Navigation.findNavController(
//                        activity, it1
//                    ).navigate(R.id.addUserEntryHostFragment)
//                }
//            }
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
        FragmentHomeBinding.inflate(layoutInflater)
}