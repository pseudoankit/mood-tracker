package lostankit7.droid.moodtracker.core

import android.app.Application
import lostankit7.droid.moodtracker.core.di.component.CoreAppComponent
import lostankit7.droid.moodtracker.core.di.component.DaggerCoreAppComponent

class MyApplication : Application() {

    val coreAppComponent: CoreAppComponent by lazy {
        DaggerCoreAppComponent.factory().create(applicationContext)
    }

}