package lostankit7.android.entry_presentation.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import lostankit7.android.entry_presentation.viewmodel.MoodEntryViewModel
import lostankit7.android.entry_presentation.viewmodel.TaskEntryViewModel
import lostankit7.droid.moodtracker.core_presentation.di.viewmodel.ViewModelKey

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MoodEntryViewModel::class)
    abstract fun bindsMoodEntryViewModel(moodEntryViewModel: MoodEntryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TaskEntryViewModel::class)
    abstract fun bindsTaskEntryViewModel(taskEntryViewModel: TaskEntryViewModel): ViewModel
}