package lostankit7.droid.moodtracker.data.repository

import android.content.Context
import android.content.SharedPreferences
import lostankit7.droid.moodtracker.data.repository.SharedPrefsRepository.SharedPrefs.get
import lostankit7.droid.moodtracker.data.repository.SharedPrefsRepository.SharedPrefs.set
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefsRepository @Inject constructor(context: Context) {
    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun isInitialLaunch(value: Boolean) {
        prefs[IS_INITIAL_LAUNCH] = value
    }

    fun isInitialLaunch() = prefs[IS_INITIAL_LAUNCH, true]


    object SharedPrefs {
        private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
            val editor = this.edit()
            operation(editor)
            editor.apply()
        }

        operator fun SharedPreferences.set(key: String, value: Any?) {
            when (value) {
                is String? -> edit { it.putString(key, value) }
                is Int -> edit { it.putInt(key, value) }
                is Boolean -> edit { it.putBoolean(key, value) }
                is Float -> edit { it.putFloat(key, value) }
                is Long -> edit { it.putLong(key, value) }
                else -> throw UnsupportedOperationException("Not yet implemented")
            }
        }

        @Suppress("UNCHECKED_CAST")
        operator fun <T> SharedPreferences.get(key: String, defaultValue: T? = null): T {
            return when (defaultValue) {
                is String, null -> getString(key, defaultValue as? String) as T
                is Int -> getInt(key, defaultValue as? Int ?: -1) as T
                is Boolean -> getBoolean(key, defaultValue as? Boolean ?: false) as T
                is Float -> getFloat(key, defaultValue as? Float ?: -1f) as T
                is Long -> getLong(key, defaultValue as? Long ?: -1) as T
                else -> throw UnsupportedOperationException("Not yet implemented")
            }
        }
    }

    companion object {
        private const val PREFS_NAME = "mood_tracker_prefs"
        private const val IS_INITIAL_LAUNCH = "is_initial_launch"
        private const val LANGUAGE_SELECTED = ""
    }
}