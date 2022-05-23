package lostankit7.droid.moodtracker.core.di.component

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import lostankit7.droid.moodtracker.core.MyApplication
import lostankit7.droid.moodtracker.core.di.module.CoreDataModule
import lostankit7.droid.moodtracker.core.di.module.CoreModule
import lostankit7.droid.moodtracker.core.di.module.CoreViewModelModule
import lostankit7.droid.moodtracker.core.di.scope.ApplicationContext
import lostankit7.droid.moodtracker.core.di.scope.ApplicationScope

@ApplicationScope
@Component(
    modules = [
        CoreDataModule::class, CoreViewModelModule::class, CoreModule::class
    ]
)
interface CoreAppComponent {

    companion object {
        val Application.coreAppComponent
            get() = (this as MyApplication).coreAppComponent
    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ApplicationContext context: Context): CoreAppComponent
    }

    @ApplicationContext
    fun provideContext(): Context

}