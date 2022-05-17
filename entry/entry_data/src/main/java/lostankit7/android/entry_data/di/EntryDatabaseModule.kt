package lostankit7.android.entry_data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import lostankit7.android.entry_data.local.EntryDatabase
import lostankit7.android.entry_data.local.dao.*
import lostankit7.droid.moodtracker.core.di.scope.ApplicationContext
import lostankit7.droid.moodtracker.core.di.scope.ApplicationScope

@Module
class EntryDatabaseModule {
    @ApplicationScope
    @Provides
    fun provideRoomDB(@ApplicationContext context: Context) : EntryDatabase = Room.databaseBuilder(
        context.applicationContext,
        EntryDatabase::class.java,
        EntryDatabase.DB_NAME
    ).build()

    @ApplicationScope
    @Provides
    fun provideUserDao(db: EntryDatabase): UserEntryDao = db.userEntryDao()

    @ApplicationScope
    @Provides
    fun provideMoodIconDao(db: EntryDatabase): MoodIconDao = db.moodIconDao()

    @ApplicationScope
    @Provides
    fun provideSuggestedMoodDao(db: EntryDatabase): SuggestedMoodIconDao = db.suggestedMoodDao()

    @ApplicationScope
    @Provides
    fun provideTaskCategoryDao(db: EntryDatabase): TaskCategoryDao = db.taskCategoryDao()

    @ApplicationScope
    @Provides
    fun provideTaskIconDao(db: EntryDatabase): TaskIconDao = db.taskIconDao()

    @ApplicationScope
    @Provides
    fun provideSuggestedTaskIconDao(db: EntryDatabase): SuggestedTaskIconDao =
        db.suggestedTaskIcon()

    @ApplicationScope
    @Provides
    fun provideSuggestedTaskNameDao(db: EntryDatabase): SuggestedTaskNameDao =
        db.suggestedTaskName()

    @ApplicationScope
    @Provides
    fun provideSuggestedMoodNameDao(db: EntryDatabase): SuggestedMoodNameDao =
        db.suggestedMoodName()
}