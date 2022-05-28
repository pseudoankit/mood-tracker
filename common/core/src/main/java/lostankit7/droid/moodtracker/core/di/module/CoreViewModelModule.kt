package lostankit7.droid.moodtracker.core.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import lostankit7.droid.moodtracker.core.di.scope.ApplicationScope
import lostankit7.droid.moodtracker.core.di.viewmodel.ViewModelFactory

@Module
abstract class CoreViewModelModule {

    @ApplicationScope
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}