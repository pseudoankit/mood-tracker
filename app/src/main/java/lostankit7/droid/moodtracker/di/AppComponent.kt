package lostankit7.droid.moodtracker.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import lostankit7.droid.moodtracker.ui.entry.mood.addEntry.MoodEntryFragment
import lostankit7.droid.moodtracker.ui.entry.mood.editMood.MoodListFragment
import lostankit7.droid.moodtracker.ui.entry.mood.editMood.UpsertMoodIconFragment
import lostankit7.droid.moodtracker.ui.entry.task.addTask.TaskEntryFragment
import lostankit7.droid.moodtracker.ui.entry.task.editTask.TaskCategoriesFragment
import lostankit7.droid.moodtracker.ui.entry.task.editTask.TaskItemsFragment
import lostankit7.droid.moodtracker.ui.userEntries.UserEntriesFragment
import lostankit7.droid.moodtracker.ui.splash.SplashFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [DataBaseModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }

    fun inject(frag: SplashFragment)
    fun inject(frag: UserEntriesFragment)
    fun inject(frag: MoodEntryFragment)
    fun inject(frag: TaskEntryFragment)
    fun inject(frag: UpsertMoodIconFragment)
    fun inject(frag: MoodListFragment)
    fun inject(frag: TaskItemsFragment)
    fun inject(frag: TaskCategoriesFragment)
}
