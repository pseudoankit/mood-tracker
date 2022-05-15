package lostankit7.droid.moodtracker

import android.app.Application
import lostankit7.droid.moodtracker.common.di.BaseComponentProvider
import lostankit7.droid.moodtracker.common.di.component.BaseComponent
import lostankit7.droid.moodtracker.common.di.component.DaggerBaseComponent
import lostankit7.droid.moodtracker.di.DaggerAppComponent

class MyApplication : Application(), BaseComponentProvider {

    lateinit var baseComponent: BaseComponent

    override fun onCreate() {
        super.onCreate()

        baseComponent = DaggerBaseComponent.factory().create(applicationContext)

        baseComponent.inject(this)
    }

    override fun provideBaseComponent(): BaseComponent {
        return baseComponent
    }
}