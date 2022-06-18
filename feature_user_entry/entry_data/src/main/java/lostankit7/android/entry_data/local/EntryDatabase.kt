package lostankit7.android.entry_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import lostankit7.android.entry_data.local.dao.*
import lostankit7.android.entry_data.local.entities.*

@Database(
    entities = [LocalUserEntry::class, LocalMoodIcon::class, LocalSuggestedMoodIcon::class, LocalTaskCategory::class, LocalTaskIcon::class, LocalSuggestedTaskIcon::class, LocalSuggestedTaskName::class, LocalSuggestedMoodName::class],
    version = EntryDatabase.DB_VERSION,
    exportSchema = true
)
abstract class EntryDatabase : RoomDatabase() {

    abstract fun userEntryDao(): UserEntryDao
    abstract fun moodIconDao(): MoodIconDao
    abstract fun suggestedMoodDao(): SuggestedMoodIconDao
    abstract fun taskCategoryDao(): TaskCategoryDao
    abstract fun taskIconDao(): TaskIconDao
    abstract fun suggestedTaskIcon(): SuggestedTaskIconDao
    abstract fun suggestedTaskName(): SuggestedTaskNameDao
    abstract fun suggestedMoodName(): SuggestedMoodNameDao

    companion object {
        const val DB_NAME = "mood_database"
        const val DB_VERSION = 1
    }
}