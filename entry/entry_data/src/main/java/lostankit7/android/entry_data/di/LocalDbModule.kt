package lostankit7.android.entry_data.di

import dagger.Module
import dagger.Provides
import lostankit7.android.entry_data.local.dao.*
import lostankit7.android.entry_data.repository.*
import lostankit7.android.entry_domain.repository.*
import javax.inject.Singleton

@Module
class LocalDbModule {

    @Singleton
    @Provides
    fun provideMoodIconRepo(moodIconDao: MoodIconDao): MoodIconRepository =
        MoodIconRepositoryImpl(moodIconDao)

    @Singleton
    @Provides
    fun provideSuggestedMoodIconRepo(dao: SuggestedMoodIconDao): SuggestedMoodIconRepository =
        SuggestedMoodIconRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideSuggestedMoodNameRepo(dao: SuggestedMoodNameDao): SuggestedMoodNameRepository =
        SuggestedMoodNameRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideSuggestedTaskIconRepo(dao: SuggestedTaskIconDao): SuggestedTaskIconRepository =
        SuggestedTaskIconRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideSuggestedTaskNameRepo(dao: SuggestedTaskNameDao): SuggestedTaskNameRepository =
        SuggestedTaskNameRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideTaskCategoryRepo(dao: TaskCategoryDao): TaskCategoryRepository =
        TaskCategoryRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideTaskIconRepo(dao: TaskIconDao): TaskIconRepository =
        TaskIconRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideUserEntryRepo(dao: UserEntryDao): UserEntriesRepository =
        UserEntryRepositoryImpl(dao)
}