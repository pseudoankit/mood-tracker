package lostankit7.droid.moodtracker.common.di.component

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import lostankit7.droid.moodtracker.common.di.module.BaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [BaseModule::class])
interface BaseComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): BaseComponent
    }

    fun inject(app: Application)

}