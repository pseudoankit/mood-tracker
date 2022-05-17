package lostankit7.android.entry_presentation.utils

import androidx.fragment.app.FragmentActivity
import lostankit7.android.entry_presentation.di.DaggerEntryComponent
import lostankit7.android.entry_presentation.di.EntryComponent
import lostankit7.droid.moodtracker.core.MyApplication

object DIUtils {
    val FragmentActivity.entryComponent: EntryComponent
        get() = DaggerEntryComponent.builder()
            .coreAppComponent((application as MyApplication).coreAppComponent).build()
}