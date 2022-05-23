package lostankit7.droid.moodtracker.di.component

import dagger.Component
import lostankit7.android.entry_data.di.EntryDatabaseModule
import lostankit7.android.entry_data.di.LocalDbModule
import lostankit7.droid.moodtracker.core.di.component.CoreAppComponent
import lostankit7.droid.moodtracker.core.di.module.CoreDataModule
import lostankit7.droid.moodtracker.core.di.scope.ApplicationScope
import lostankit7.droid.moodtracker.di.module.ViewModelModule
import lostankit7.droid.moodtracker.presentation.splash.SplashFragment

@ApplicationScope
@Component(
    modules = [
        ViewModelModule::class, CoreDataModule::class,
        EntryDatabaseModule::class, LocalDbModule::class
    ],
    dependencies = [CoreAppComponent::class]
)
interface AppComponent {

    fun inject(frag: SplashFragment)

}
