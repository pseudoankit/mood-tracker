package lostankit7.droid.moodtracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import lostankit7.droid.moodtracker.data.database.AppDatabase
import lostankit7.droid.moodtracker.data.database.dao.MoodIconDao
import lostankit7.droid.moodtracker.data.database.dao.SuggestedMoodDao
import lostankit7.droid.moodtracker.data.database.dao.TaskCategoryDao
import lostankit7.droid.moodtracker.data.database.dao.UserEntryDao
import lostankit7.droid.moodtracker.helper.constant.DBConst
import javax.inject.Singleton

@Module
class DataBaseModule {

    //todo binds vs provides
    @Singleton
    @Provides
    fun provideRoomDB(context: Context) = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        DBConst.DB_NAME
    ).build()


    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase) : UserEntryDao = db.userEntryDao()

    @Singleton
    @Provides
    fun provideMoodIconDao(db: AppDatabase) : MoodIconDao = db.moodIconDao()

    @Singleton
    @Provides
    fun provideSuggestedMoodDao(db: AppDatabase) : SuggestedMoodDao = db.suggestedMoodDao()

    @Singleton
    @Provides
    fun provideTaskCategoryDao(db: AppDatabase) : TaskCategoryDao = db.taskCategoryDao()
}
