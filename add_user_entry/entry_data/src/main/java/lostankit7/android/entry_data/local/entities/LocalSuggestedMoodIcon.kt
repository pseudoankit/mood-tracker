package lostankit7.android.entry_data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalSuggestedMoodIcon(override var icon: String, override var isSolid: Boolean) :
    LocalIcon() {
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0
}