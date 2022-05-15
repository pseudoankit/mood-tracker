package lostankit7.android.entry_data.local.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class LocalMoodIcon(
    override var icon: String, override var name: String,
    override var isSolid: Boolean = false,
) : LocalIcon() {

    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0

}
