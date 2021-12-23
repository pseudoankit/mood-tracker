package lostankit7.droid.moodtracker.data.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import lostankit7.droid.moodtracker.data.database.dao.UserEntryDao
import lostankit7.droid.moodtracker.data.database.entities.UserEntry
import javax.inject.Inject

@Database(entities = [UserEntry::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userEntryDao(): UserEntryDao

    companion object {
        private const val dbName = "mood_database"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context,scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    dbName
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