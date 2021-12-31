package lostankit7.droid.moodtracker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import lostankit7.droid.moodtracker.data.database.dao.MoodIconDao
import lostankit7.droid.moodtracker.data.database.dao.SuggestedMoodDao
import lostankit7.droid.moodtracker.data.database.dao.TaskCategoryDao
import lostankit7.droid.moodtracker.data.database.dao.UserEntryDao
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMood
import lostankit7.droid.moodtracker.data.database.entities.TaskCategory
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import lostankit7.droid.moodtracker.helper.constant.DBConst

@Database(
    entities = [UserEntry::class, MoodIcon::class, SuggestedMood::class, TaskCategory::class],
    version = DBConst.DB_VERSION,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userEntryDao(): UserEntryDao
    abstract fun moodIconDao(): MoodIconDao
    abstract fun suggestedMoodDao(): SuggestedMoodDao
    abstract fun taskCategoryDao() : TaskCategoryDao

}