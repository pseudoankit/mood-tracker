package lostankit7.droid.moodtracker.di.component

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import lostankit7.droid.moodtracker.common.di.scope.ApplicationContext
import lostankit7.droid.moodtracker.common.di.scope.ApplicationScope
import lostankit7.droid.moodtracker.data.preferences.DefaultPreferences
import lostankit7.droid.moodtracker.domain.preferences.Preferences
import javax.inject.Singleton

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