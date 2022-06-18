package lostankit7.android.entry_data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalTaskIcon(
    override var icon: String, override var name: String, val category: String,
    override var isSolid: Boolean = true,
) : LocalIcon() {

    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0
}
