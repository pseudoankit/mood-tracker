package lostankit7.android.entry_presentation.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
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

    @Suppress("UNCHECKED_CAST")
    fun <F : Fragment> AppCompatActivity.getFragment(fragmentClass: Class<F>): F? {
        val navHostFragment = this.supportFragmentManager.fragments.first() as NavHostFragment

        navHostFragment.childFragmentManager.fragments.forEach {
            if (fragmentClass.isAssignableFrom(it.javaClass)) {
                return it as F
            }
        }

        return null
    }
}