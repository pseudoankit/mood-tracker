package lostankit7.droid.moodtracker.common.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import lostankit7.droid.moodtracker.common.di.scope.AppContext

@Module
class BaseModule {

    @AppContext
    @Provides
    fun provideApplicationContext(context: Context) = context

}