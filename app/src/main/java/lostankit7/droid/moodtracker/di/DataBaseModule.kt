package lostankit7.droid.moodtracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import lostankit7.droid.moodtracker.common.di.scope.ApplicationContext
import lostankit7.android.entry_data.database.AppDatabase
import lostankit7.droid.moodtracker.data.database.dao.*
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideRoomDB(@ApplicationContext context: Context) = Room.databaseBuilder(
        context.applicationContext,
        lostankit7.android.entry_data.database.AppDatabase::class.java,
        lostankit7.android.entry_data.database.AppDatabase.DB_NAME
    ).build()

    @Singleton
    @Provides
    fun provideUserDao(db: lostankit7.android.entry_data.database.AppDatabase): lostankit7.android.entry_data.database.dao.UserEntryDao = db.userEntryDao()

    @Singleton
    @Provides
    fun provideMoodIconDao(db: lostankit7.android.entry_data.database.AppDatabase): lostankit7.android.entry_data.database.dao.MoodIconDao = db.moodIconDao()

    @Singleton
    @Provides
    fun provideSuggestedMoodDao(db: lostankit7.android.entry_data.database.AppDatabase): lostankit7.android.entry_data.database.dao.SuggestedMoodIconDao = db.suggestedMoodDao()

    @Singleton
    @Provides
    fun provideTaskCategoryDao(db: lostankit7.android.entry_data.database.AppDatabase): lostankit7.android.entry_data.database.dao.TaskCategoryDao = db.taskCategoryDao()

    @Singleton
    @Provides
    fun provideTaskIconDao(db: lostankit7.android.entry_data.database.AppDatabase): lostankit7.android.entry_data.database.dao.TaskIconDao = db.taskIconDao()

    @Singleton
    @Provides
    fun provideSuggestedTaskIconDao(db: lostankit7.android.entry_data.database.AppDatabase): lostankit7.android.entry_data.database.dao.SuggestedTaskIconDao = db.suggestedTaskIcon()

    @Singleton
    @Provides
    fun provideSuggestedTaskNameDao(db: lostankit7.android.entry_data.database.AppDatabase): lostankit7.android.entry_data.database.dao.SuggestedTaskNameDao = db.suggestedTaskName()

    @Singleton
    @Provides
    fun provideSuggestedMoodNameDao(db: lostankit7.android.entry_data.database.AppDatabase): lostankit7.android.entry_data.database.dao.SuggestedMoodNameDao = db.suggestedMoodName()
}
