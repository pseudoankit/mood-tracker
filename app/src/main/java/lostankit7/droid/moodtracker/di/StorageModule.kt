package lostankit7.droid.moodtracker.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import lostankit7.droid.moodtracker.helper.constant.PREFS_NAME
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideSharedPrefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
}