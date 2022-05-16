package lostankit7.droid.moodtracker.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import lostankit7.android.entry_data.di.EntryDatabaseModule
import lostankit7.android.entry_data.di.LocalDbModule
import lostankit7.droid.moodtracker.common.di.scope.ApplicationContext
import lostankit7.droid.moodtracker.common.di.component.BaseDataModule
import lostankit7.droid.moodtracker.presentation.splash.SplashFragment
import lostankit7.android.entry_presentation.fragment.addEntry.AddMoodEntryFragment
import lostankit7.android.entry_presentation.fragment.addEntry.AddTaskEntryFragment
import lostankit7.droid.moodtracker.di.module.ViewModelModule
import lostankit7.android.entry_presentation.fragment.displayentry.DisplayUserEntriesBaseFragment
import lostankit7.android.entry_presentation.fragment.editEntry.editmood.DisplayMoodIconsFragment
import lostankit7.android.entry_presentation.fragment.editEntry.editmood.UpsertMoodIconFragment
import lostankit7.android.entry_presentation.fragment.editEntry.edittask.DisplayTaskCategoriesFragment
import lostankit7.android.entry_presentation.fragment.editEntry.edittask.DisplayTasksOfCategoryFragment
import lostankit7.android.entry_presentation.fragment.editEntry.edittask.UpsertTaskIconFragment
import lostankit7.droid.moodtracker.presentation.MainActivity
import lostankit7.droid.moodtracker.presentation.home.MoreFragment
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
