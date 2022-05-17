package lostankit7.android.entry_presentation.utils

import androidx.fragment.app.FragmentActivity
import lostankit7.android.entry_presentation.AddUserEntryActivity
import lostankit7.android.entry_presentation.di.DaggerEntryComponent
import lostankit7.android.entry_presentation.di.EntryComponent
import lostankit7.droid.moodtracker.core.MyApplication
import lostankit7.droid.moodtracker.core.databinding.CommonActionBarBinding
import lostankit7.droid.moodtracker.core.presentation.utils.ActionBarUtils.applyDefault

object Utils {

    val FragmentActivity.mActionBar: CommonActionBarBinding?
        get() = (this as AddUserEntryActivity).actionBar

    val FragmentActivity.entryComponent: EntryComponent
        get() = DaggerEntryComponent.builder()
            .coreAppComponent((application as MyApplication).coreAppComponent).build()
}