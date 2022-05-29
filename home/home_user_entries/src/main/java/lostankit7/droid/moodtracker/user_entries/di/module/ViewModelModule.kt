package lostankit7.droid.moodtracker.user_entries.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import lostankit7.droid.moodtracker.core_presentation.di.viewmodel.ViewModelKey
import lostankit7.droid.moodtracker.user_entries.presentation.user_entries.viewmodel.UserEntriesViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserEntriesViewModel::class)
    abstract fun bindsUserEntriesViewModel(viewModel: UserEntriesViewModel): ViewModel
}