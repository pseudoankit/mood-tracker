package lostankit7.droid.moodtracker.data.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import lostankit7.droid.moodtracker.data.database.dao.MoodIconDao
import lostankit7.droid.moodtracker.data.database.dao.SuggestedMoodDao
import lostankit7.droid.moodtracker.data.database.dao.UserEntryDao
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMood
import lostankit7.droid.moodtracker.data.database.entities.UserEntry

@Database(
    entities = [UserEntry::class, MoodIcon::class, SuggestedMood::class],
    version = AppDatabase.DB_VERSION,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userEntryDao(): UserEntryDao
    abstract fun moodIconDao(): MoodIconDao
    abstract fun suggestedMoodDao(): SuggestedMoodDao

    companion object {

        const val DB_NAME = "mood_database"
        const val DB_VERSION = 1

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME
                ).addCallback(AppDatabaseCallBack(scope)).build()
                INSTANCE = instance
                instance
            }
        }

        //todo check for callback usecase
        class AppDatabaseCallBack(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch {

                    }
                }
            }
        }
    }
}