package lostankit7.droid.moodtracker

import android.app.Application
import lostankit7.droid.moodtracker.di.DaggerAppComponent

class MyApplication : Application() {
    val appComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}