package lostankit7.droid.moodtracker.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import lostankit7.android.entry_data.di.EntryDatabaseModule
import lostankit7.android.entry_data.di.LocalDbModule
import lostankit7.droid.moodtracker.core.di.scope.ApplicationContext
import lostankit7.droid.moodtracker.core.di.component.BaseDataModule
import lostankit7.droid.moodtracker.presentation.splash.SplashFragment
import lostankit7.droid.moodtracker.di.module.ViewModelModule
import lostankit7.droid.moodtracker.presentation.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ViewModelModule::class,
    BaseDataModule::class,
    EntryDatabaseModule::class, LocalDbModule::class
])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ApplicationContext context: Context): AppComponent
    }

    fun inject(frag: SplashFragment)
    fun inject(activity: MainActivity)

}
