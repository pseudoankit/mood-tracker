package lostankit7.droid.moodtracker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import lostankit7.droid.moodtracker.data.database.dao.*
import lostankit7.droid.moodtracker.data.database.entities.*

@Database(
    entities = [UserEntry::class, MoodIcon::class, SuggestedMoodIcon::class, TaskCategory::class, TaskIcon::class, SuggestedTaskIcon::class],
    version = AppDatabase.DB_VERSION,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userEntryDao(): UserEntryDao
    abstract fun moodIconDao(): MoodIconDao
    abstract fun suggestedMoodDao(): SuggestedMoodIconDao
    abstract fun taskCategoryDao(): TaskCategoryDao
    abstract fun taskIconDao(): TaskIconDao
    abstract fun suggestedTaskIcon() : SuggestedTaskIconDao

    companion object {
        const val DB_NAME = "mood_database"
        const val DB_VERSION = 1
    }
}