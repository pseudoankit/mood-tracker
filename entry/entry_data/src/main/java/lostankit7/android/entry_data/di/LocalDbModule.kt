package lostankit7.android.entry_data.di

import dagger.Module
import dagger.Provides
import lostankit7.android.entry_data.local.dao.*
import lostankit7.android.entry_data.repository.*
import lostankit7.android.entry_domain.repository.*
import lostankit7.droid.moodtracker.core.di.scope.ApplicationScope

@Module
class LocalDbModule {

    @ApplicationScope
    @Provides
    fun provideMoodIconRepo(moodIconDao: MoodIconDao): MoodIconRepository =
        MoodIconRepositoryImpl(moodIconDao)

    @ApplicationScope
    @Provides
    fun provideSuggestedMoodIconRepo(dao: SuggestedMoodIconDao): SuggestedMoodIconRepository =
        SuggestedMoodIconRepositoryImpl(dao)

    @ApplicationScope
    @Provides
    fun provideSuggestedMoodNameRepo(dao: SuggestedMoodNameDao): SuggestedMoodNameRepository =
        SuggestedMoodNameRepositoryImpl(dao)

    @ApplicationScope
    @Provides
    fun provideSuggestedTaskIconRepo(dao: SuggestedTaskIconDao): SuggestedTaskIconRepository =
        SuggestedTaskIconRepositoryImpl(dao)

    @ApplicationScope
    @Provides
    fun provideSuggestedTaskNameRepo(dao: SuggestedTaskNameDao): SuggestedTaskNameRepository =
        SuggestedTaskNameRepositoryImpl(dao)

    @ApplicationScope
    @Provides
    fun provideTaskCategoryRepo(dao: TaskCategoryDao): TaskCategoryRepository =
        TaskCategoryRepositoryImpl(dao)

    @ApplicationScope
    @Provides
    fun provideTaskIconRepo(dao: TaskIconDao): TaskIconRepository =
        TaskIconRepositoryImpl(dao)

    @ApplicationScope
    @Provides
    fun provideUserEntryRepo(dao: UserEntryDao): UserEntriesRepository =
        UserEntryRepositoryImpl(dao)
}