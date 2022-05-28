package lostankit7.droid.moodtracker.home_more.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import lostankit7.droid.moodtracker.core_presentation.di.viewmodel.ViewModelKey
import lostankit7.droid.moodtracker.home_more.presentation.viewmodel.MoreViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MoreViewModel::class)
    abstract fun bindsViewModel(viewModel: MoreViewModel): ViewModel
}