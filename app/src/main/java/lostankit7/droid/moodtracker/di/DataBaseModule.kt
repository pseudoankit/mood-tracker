package lostankit7.droid.moodtracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import lostankit7.droid.moodtracker.data_layer.database.AppDatabase
import lostankit7.droid.moodtracker.data_layer.database.dao.*
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideRoomDB(context: Context) = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        AppDatabase.DB_NAME
    ).build()


    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): UserEntryDao = db.userEntryDao()

    @Singleton
    @Provides
    fun provideMoodIconDao(db: AppDatabase): MoodIconDao = db.moodIconDao()

    @Singleton
    @Provides
    fun provideSuggestedMoodDao(db: AppDatabase): SuggestedMoodIconDao = db.suggestedMoodDao()

    @Singleton
    @Provides
    fun provideTaskCategoryDao(db: AppDatabase): TaskCategoryDao = db.taskCategoryDao()

    @Singleton
    @Provides
    fun provideTaskIconDao(db: AppDatabase): TaskIconDao = db.taskIconDao()

    @Singleton
    @Provides
    fun provideSuggestedTaskIconDao(db: AppDatabase): SuggestedTaskIconDao = db.suggestedTaskIcon()

    @Singleton
    @Provides
    fun provideSuggestedTaskNameDao(db: AppDatabase): SuggestedTaskNameDao = db.suggestedTaskName()

    @Singleton
    @Provides
    fun provideSuggestedMoodNameDao(db: AppDatabase): SuggestedMoodNameDao = db.suggestedMoodName()
}
