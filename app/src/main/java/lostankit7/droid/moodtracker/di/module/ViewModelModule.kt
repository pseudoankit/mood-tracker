package lostankit7.droid.moodtracker.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import lostankit7.droid.moodtracker.core_presentation.di.viewmodel.ViewModelKey
import lostankit7.droid.moodtracker.presentation.splash.SplashViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindsSplashViewModel(splashViewModel: SplashViewModel): ViewModel
}