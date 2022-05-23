package lostankit7.droid.moodtracker.home_common.di.component

import android.content.Context
import dagger.Component
import lostankit7.droid.moodtracker.core.di.component.CoreAppComponent
import lostankit7.droid.moodtracker.core.di.scope.ApplicationContext

@Component(
    dependencies = [CoreAppComponent::class],
    modules = []
)
interface HomeComponent {

    @ApplicationContext
    fun provideContext() : Context


}