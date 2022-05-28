package lostankit7.droid.moodtracker.core.di.module

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import lostankit7.droid.moodtracker.core.data.preferences.DefaultPreferences
import lostankit7.droid.moodtracker.core.di.scope.ApplicationContext
import lostankit7.droid.moodtracker.core.di.scope.ApplicationScope
import lostankit7.droid.moodtracker.core.domain.preferences.Preferences

@Module
class CoreDataModule {

    @ApplicationScope
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(Preferences.PREFS_NAME, Context.MODE_PRIVATE)

    @ApplicationScope
    @Provides
    fun provideDefaultPreferences(preferences: SharedPreferences): Preferences =
        DefaultPreferences(preferences)
}