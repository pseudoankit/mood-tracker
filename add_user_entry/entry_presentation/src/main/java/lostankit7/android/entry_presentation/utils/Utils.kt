package lostankit7.android.entry_presentation.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import lostankit7.android.entry_presentation.AddUserEntryHostFragment
import lostankit7.android.entry_presentation.databinding.CommonActionBarBinding
import lostankit7.android.entry_presentation.di.DaggerEntryComponent
import lostankit7.android.entry_presentation.di.EntryComponent
import lostankit7.droid.moodtracker.core.MyApplication

object Utils {

    val Fragment.mActionBar: CommonActionBarBinding?
        get() = (this.parentFragment as? AddUserEntryHostFragment)?.actionBar

    val FragmentActivity.entryComponent: EntryComponent
        get() = DaggerEntryComponent.builder()
            .coreAppComponent((application as MyApplication).coreAppComponent).build()
}