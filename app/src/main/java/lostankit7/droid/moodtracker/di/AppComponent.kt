package lostankit7.droid.moodtracker.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import lostankit7.droid.moodtracker.ui.main.newentry.mood.MoodEntryFragment
import lostankit7.droid.moodtracker.ui.main.newentry.task.TaskEntryFragment
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
}
