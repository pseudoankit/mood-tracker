package lostankit7.droid.moodtracker.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import lostankit7.droid.moodtracker.ui.fragment.SplashFragment
import lostankit7.droid.moodtracker.ui.fragment.addentry.AddMoodEntryFragment
import lostankit7.droid.moodtracker.ui.fragment.addentry.AddTaskEntryFragment
import lostankit7.droid.moodtracker.ui.fragment.displayentry.DisplayUserEntriesBaseFragment
import lostankit7.droid.moodtracker.ui.fragment.edit.editmood.DisplayMoodIconsFragment
import lostankit7.droid.moodtracker.ui.fragment.edit.editmood.UpsertMoodIconFragment
import lostankit7.droid.moodtracker.ui.fragment.edit.edittask.DisplayTaskCategoriesFragment
import lostankit7.droid.moodtracker.ui.fragment.edit.edittask.DisplayTasksOfCategoryFragment
import lostankit7.droid.moodtracker.ui.fragment.edit.edittask.UpsertTaskIconFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [DataBaseModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }

    fun inject(frag: SplashFragment)
    fun inject(frag: DisplayUserEntriesBaseFragment)
    fun inject(frag: AddMoodEntryFragment)
    fun inject(frag: AddTaskEntryFragment)
    fun inject(frag: UpsertMoodIconFragment)
    fun inject(frag: UpsertTaskIconFragment)
    fun inject(frag: DisplayMoodIconsFragment)
    fun inject(frag: DisplayTasksOfCategoryFragment)
    fun inject(frag: DisplayTaskCategoriesFragment)
}
