package lostankit7.droid.moodtracker.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import lostankit7.droid.moodtracker.ui.fragment.addentry.AddMoodEntryFragment
import lostankit7.droid.moodtracker.ui.fragment.upsert.MoodIconsFragment
import lostankit7.droid.moodtracker.ui.fragment.upsert.UpsertMoodIconFragment
import lostankit7.droid.moodtracker.ui.fragment.addentry.AddTaskEntryFragment
import lostankit7.droid.moodtracker.ui.fragment.upsert.TaskCategoriesFragment
import lostankit7.droid.moodtracker.ui.fragment.upsert.TaskItemsFragment
import lostankit7.droid.moodtracker.ui.fragment.upsert.UpsertTaskIconFragment
import lostankit7.droid.moodtracker.ui.fragment.displayentry.UserEntriesBaseFragment
import lostankit7.droid.moodtracker.ui.fragment.SplashFragment
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
    fun inject(frag: UserEntriesBaseFragment)
    fun inject(frag: AddMoodEntryFragment)
    fun inject(frag: AddTaskEntryFragment)
    fun inject(frag: UpsertMoodIconFragment)
    fun inject(frag: UpsertTaskIconFragment)
    fun inject(frag: MoodIconsFragment)
    fun inject(frag: TaskItemsFragment)
    fun inject(frag: TaskCategoriesFragment)
}
