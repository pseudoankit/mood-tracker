package lostankit7.android.entry_data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalTaskCategory(override var name: String) : LocalIcon() {
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0
}