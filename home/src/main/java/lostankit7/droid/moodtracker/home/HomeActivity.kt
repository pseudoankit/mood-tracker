package lostankit7.droid.moodtracker.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lostankit7.droid.moodtracker.home.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}