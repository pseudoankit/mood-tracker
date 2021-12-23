package lostankit7.droid.moodtracker.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import lostankit7.droid.moodtracker.data.database.AppDatabase
import lostankit7.droid.moodtracker.data.database.dao.UserEntryDao
import javax.inject.Singleton

@Module
class DataBaseModule {

    //todo binds vs provides
    @Singleton
    @Provides
    fun provideRoomDB(context: Context) = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "mood_database"
    ).build()


    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase) : UserEntryDao = db.userEntryDao()

}
