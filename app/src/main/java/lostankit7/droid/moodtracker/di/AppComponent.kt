package lostankit7.droid.moodtracker.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import lostankit7.droid.moodtracker.ui.main.entry.mood.addEntry.MoodEntryFragment
import lostankit7.droid.moodtracker.ui.main.entry.mood.editMood.EditMoodFragment
import lostankit7.droid.moodtracker.ui.main.entry.mood.editMood.UpsertMoodIconFragment
import lostankit7.droid.moodtracker.ui.main.entry.task.addTask.TaskEntryFragment
import lostankit7.droid.moodtracker.ui.main.userEntries.UserEntriesFragment
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
    fun inject(frag: EditMoodFragment)
}
