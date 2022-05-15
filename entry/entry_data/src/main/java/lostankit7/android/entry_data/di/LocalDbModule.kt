package lostankit7.android.entry_data.di

import dagger.Module
import dagger.Provides
import lostankit7.android.entry_data.local.dao.*
import lostankit7.android.entry_data.repository.*
import javax.inject.Singleton

@Module
class LocalDbModule {

    @Singleton
    @Provides
    fun provideMoodIconRepo(moodIconDao: MoodIconDao) = MoodIconRepositoryImpl(moodIconDao)

    @Singleton
    @Provides
    fun provideSuggestedMoodIconRepo(dao: SuggestedMoodIconDao) =
        SuggestedMoodIconRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideSuggestedMoodNameRepo(dao: SuggestedMoodNameDao) =
        SuggestedMoodNameRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideSuggestedTaskIconRepo(dao: SuggestedTaskIconDao) =
        SuggestedTaskIconRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideSuggestedTaskNameRepo(dao: SuggestedTaskNameDao) =
        SuggestedTaskNameRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideTaskCategoryRepo(dao: TaskCategoryDao) =
        TaskCategoryRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideTaskIconRepo(dao: TaskIconDao) =
        TaskIconRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideUserEntryRepo(dao: UserEntryDao) =
        UserEntryRepositoryImpl(dao)
}