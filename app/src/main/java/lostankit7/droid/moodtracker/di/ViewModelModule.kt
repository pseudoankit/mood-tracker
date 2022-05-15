package lostankit7.droid.moodtracker.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import lostankit7.droid.moodtracker.core_presentation.di.viewmodel.ViewModelKey
import lostankit7.droid.moodtracker.presentation.viewmodel.MoodEntryViewModel
import lostankit7.droid.moodtracker.presentation.viewmodel.SplashViewModel
import lostankit7.droid.moodtracker.presentation.viewmodel.TaskEntryViewModel
import lostankit7.droid.moodtracker.presentation.viewmodel.UserEntriesViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @lostankit7.droid.moodtracker.core_presentation.di.viewmodel.ViewModelKey(MoodEntryViewModel::class)
    abstract fun bindsMoodEntryViewModel(moodEntryViewModel: MoodEntryViewModel): ViewModel

    @Binds
    @IntoMap
    @lostankit7.droid.moodtracker.core_presentation.di.viewmodel.ViewModelKey(SplashViewModel::class)
    abstract fun bindsSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @lostankit7.droid.moodtracker.core_presentation.di.viewmodel.ViewModelKey(TaskEntryViewModel::class)
    abstract fun bindsTaskEntryViewModel(taskEntryViewModel: TaskEntryViewModel): ViewModel

    @Binds
    @IntoMap
    @lostankit7.droid.moodtracker.core_presentation.di.viewmodel.ViewModelKey(UserEntriesViewModel::class)
    abstract fun bindsUserEntriesViewModel(userEntriesViewModel: UserEntriesViewModel): ViewModel

}