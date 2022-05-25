package lostankit7.droid.moodtracker.user_entries.di.component

import androidx.fragment.app.FragmentActivity
import dagger.Component
import lostankit7.android.entry_data.di.EntryDatabaseModule
import lostankit7.android.entry_data.di.LocalDbModule
import lostankit7.droid.moodtracker.core.di.component.CoreAppComponent
import lostankit7.droid.moodtracker.core.di.component.CoreAppComponent.Companion.coreAppComponent
import lostankit7.droid.moodtracker.user_entries.di.module.ViewModelModule
import lostankit7.droid.moodtracker.user_entries.presentation.fragment.UserEntriesFragment

@Component(
    dependencies = [CoreAppComponent::class],
    modules = [ViewModelModule::class, EntryDatabaseModule::class, LocalDbModule::class]
)
interface HomeUserEntriesComponent {

    companion object {
        val FragmentActivity.createComponent: HomeUserEntriesComponent
            get() = DaggerHomeUserEntriesComponent.builder()
                .coreAppComponent(application.coreAppComponent)
                .build()
    }

    fun inject(fragment: UserEntriesFragment)
}