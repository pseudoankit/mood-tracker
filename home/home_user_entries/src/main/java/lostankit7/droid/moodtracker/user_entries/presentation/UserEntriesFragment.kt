package lostankit7.droid.moodtracker.user_entries.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.ViewModelProvider
import lostankit7.droid.moodtracker.core.presentation.base.fragment.BaseComposeDaggerFragment
import lostankit7.droid.moodtracker.core_ui.compose.values.LocalSpacing
import lostankit7.droid.moodtracker.user_entries.di.component.HomeUserEntriesComponent.Companion.createComponent
import lostankit7.droid.moodtracker.user_entries.presentation.user_entries.compose.DrawUserEntryScreen
import lostankit7.droid.moodtracker.user_entries.presentation.user_entries.viewmodel.UserEntriesViewModel

class UserEntriesFragment :
    BaseComposeDaggerFragment<UserEntriesViewModel>() {

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
                        DrawUserEntryScreen(viewModel)
                    }
                }
            }
        }
    }

    override fun injectFragment() {
        activity?.createComponent?.inject(this)
    }

    override fun ViewModelProvider.initiateViewModel() = this[UserEntriesViewModel::class.java]
}