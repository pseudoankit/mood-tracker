package lostankit7.droid.moodtracker.core.utils

object Utils {
    fun <T> fastLazy(block: () -> T) = lazy(LazyThreadSafetyMode.NONE, block)
}