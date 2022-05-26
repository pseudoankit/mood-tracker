package lostankit7.droid.moodtracker.home_more.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.ViewModelProvider
import lostankit7.droid.moodtracker.core.presentation.base.fragment.BaseComposeDaggerFragment
import lostankit7.droid.moodtracker.core_ui.compose.values.LocalSpacing
import lostankit7.droid.moodtracker.home_more.di.component.HomeMoreComponent.Companion.createComponent
import lostankit7.droid.moodtracker.home_more.presentation.compose.HomeMoreScreen
import lostankit7.droid.moodtracker.home_more.presentation.viewmodel.MoreViewModel

@ExperimentalComposeUiApi
class MoreFragment : BaseComposeDaggerFragment<MoreViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return context?.let { context ->
            ComposeView(context).apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                setContent {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(LocalSpacing.current.screenPadding)
                    ) {
                        HomeMoreScreen(viewModel)
                    }
                }
            }
        }
    }

    override fun ViewModelProvider.initiateViewModel(): MoreViewModel {
        return get(MoreViewModel::class.java)
    }

    override fun injectFragment() {
        activity?.createComponent?.inject(this)
    }
}