package lostankit7.droid.moodtracker.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lostankit7.droid.moodtracker.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}