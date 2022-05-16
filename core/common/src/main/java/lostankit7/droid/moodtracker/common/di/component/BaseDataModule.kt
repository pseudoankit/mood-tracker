package lostankit7.droid.moodtracker.common.di.component

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import lostankit7.droid.moodtracker.common.di.scope.ApplicationContext
import lostankit7.droid.moodtracker.common.di.scope.ApplicationScope
import lostankit7.droid.moodtracker.common.data.preferences.DefaultPreferences
import lostankit7.droid.moodtracker.common.domain.preferences.Preferences

@Module
class BaseDataModule {

    @ApplicationScope
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(Preferences.PREFS_NAME, Context.MODE_PRIVATE)

    @ApplicationScope
    @Provides
    fun provideDefaultPreferences(preferences: SharedPreferences): Preferences =
        DefaultPreferences(preferences)
}