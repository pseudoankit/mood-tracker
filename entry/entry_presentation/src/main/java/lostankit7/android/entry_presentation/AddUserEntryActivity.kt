package lostankit7.android.entry_presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import lostankit7.android.entry_presentation.databinding.ActivityAddUserEntryBinding
import lostankit7.android.entry_presentation.di.DaggerEntryComponent
import lostankit7.android.entry_presentation.di.EntryComponent
import lostankit7.android.entry_presentation.fragment.addEntry.AddTaskEntryFragment
import lostankit7.android.entry_presentation.fragment.editEntry.editmood.UpsertMoodIconFragment
import lostankit7.android.entry_presentation.fragment.editEntry.edittask.UpsertTaskIconFragment
import lostankit7.droid.moodtracker.core_presentation.databinding.CommonActionBarBinding

class AddUserEntryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddUserEntryBinding
    private val navController: NavController by lazy(LazyThreadSafetyMode.NONE) {
        findNavController(R.id.fragment_container)
    }
    val entryComponent : EntryComponent by lazy { DaggerEntryComponent.factory().create(baseContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
    }

    private fun initListener() {
        binding.actionBar.btnBack.setOnClickListener {
            navController.popBackStack()
        }
        binding.actionBar.btnSave.setOnClickListener {
            when (val fragment =
                supportFragmentManager.findFragmentById(R.id.fragment_container)?.childFragmentManager?.primaryNavigationFragment) {
                is AddTaskEntryFragment -> fragment.saveEntry()
                is UpsertMoodIconFragment -> fragment.saveMoodIcon()
                is UpsertTaskIconFragment -> fragment.saveTaskIcon()
            }
        }
    }

    val actionBar: CommonActionBarBinding?
        get() {
            return if (!::binding.isInitialized) null else binding.actionBar
        }
}