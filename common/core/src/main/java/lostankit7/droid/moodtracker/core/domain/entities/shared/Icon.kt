package lostankit7.droid.moodtracker.core.domain.entities.shared

import android.text.SpannableStringBuilder

data class Icon(override var name: String, override var icon: String) : BaseIcon() {

    companion object {
        val List<Icon>.transformAsString
            get() = run {
                val tasks = SpannableStringBuilder()
                for (i in this.indices) {
                    tasks.append("  |  ${this[i].icon} ${this[i].name}")
                }
                tasks.substring(4)
            }
    }
}