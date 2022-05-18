package lostankit7.droid.moodtracker.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import lostankit7.android.entry_data.di.EntryDatabaseModule
import lostankit7.android.entry_data.di.LocalDbModule
import lostankit7.droid.moodtracker.core.di.component.CoreAppComponent
import lostankit7.droid.moodtracker.core.di.scope.ApplicationContext
import lostankit7.droid.moodtracker.core.di.module.CoreDataModule
import lostankit7.droid.moodtracker.core.di.module.CoreModule
import lostankit7.droid.moodtracker.presentation.splash.SplashFragment
import lostankit7.droid.moodtracker.di.module.ViewModelModule
import lostankit7.droid.moodtracker.presentation.MainActivity
import lostankit7.droid.moodtracker.core.di.scope.ApplicationScope

@ApplicationScope
@Component(modules = [
    ViewModelModule::class,
    CoreDataModule::class,
    EntryDatabaseModule::class, LocalDbModule::class
], dependencies = [CoreAppComponent::class])
interface AppComponent {

    fun inject(frag: SplashFragment)
    fun inject(activity: MainActivity)

}
