package lostankit7.android.entry_data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import lostankit7.android.entry_data.local.EntryDatabase
import lostankit7.android.entry_data.local.dao.*
import lostankit7.droid.moodtracker.core.di.scope.ApplicationContext
import javax.inject.Singleton

@Module
class EntryDatabaseModule {
    @Singleton
    @Provides
    fun provideRoomDB(@ApplicationContext context: Context) = Room.databaseBuilder(
        context.applicationContext,
        EntryDatabase::class.java,
        EntryDatabase.DB_NAME
    ).build()

    @Singleton
    @Provides
    fun provideUserDao(db: EntryDatabase): UserEntryDao = db.userEntryDao()

    @Singleton
    @Provides
    fun provideMoodIconDao(db: EntryDatabase): MoodIconDao = db.moodIconDao()

    @Singleton
    @Provides
    fun provideSuggestedMoodDao(db: EntryDatabase): SuggestedMoodIconDao = db.suggestedMoodDao()

    @Singleton
    @Provides
    fun provideTaskCategoryDao(db: EntryDatabase): TaskCategoryDao = db.taskCategoryDao()

    @Singleton
    @Provides
    fun provideTaskIconDao(db: EntryDatabase): TaskIconDao = db.taskIconDao()

    @Singleton
    @Provides
    fun provideSuggestedTaskIconDao(db: EntryDatabase): SuggestedTaskIconDao =
        db.suggestedTaskIcon()

    @Singleton
    @Provides
    fun provideSuggestedTaskNameDao(db: EntryDatabase): SuggestedTaskNameDao =
        db.suggestedTaskName()

    @Singleton
    @Provides
    fun provideSuggestedMoodNameDao(db: EntryDatabase): SuggestedMoodNameDao =
        db.suggestedMoodName()
}