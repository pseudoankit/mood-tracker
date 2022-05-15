package lostankit7.droid.moodtracker.common.di.utils

import android.content.Context
import lostankit7.droid.moodtracker.common.di.BaseComponentProvider
import lostankit7.droid.moodtracker.common.di.component.BaseComponent

object InjectUtils {

    fun provideBaseComponent(applicationContext: Context): BaseComponent {
        return if (applicationContext is BaseComponentProvider) {
            (applicationContext as BaseComponentProvider).provideBaseComponent()
        } else {
            throw IllegalStateException("Provide the application context which implement BaseComponentProvider")
        }
    }

}