package lostankit7.droid.moodtracker.core.utils

import android.app.Application
import lostankit7.droid.moodtracker.core.MyApplication

val Application.coreAppComponent get() = (this as MyApplication).coreAppComponent