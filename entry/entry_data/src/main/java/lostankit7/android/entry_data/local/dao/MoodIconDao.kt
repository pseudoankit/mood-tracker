package lostankit7.android.entry_data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import lostankit7.android.entry_data.local.entities.LocalMoodIcon

@Dao
interface MoodIconDao {

    @Query("SELECT * FROM LocalMoodIcon")
    fun getMoodIcons(): Flow<List<LocalMoodIcon>>

    @Insert
    suspend fun insertMoodIcon(icon: LocalMoodIcon)

    @Delete
    fun deleteMoodIcon(icon: LocalMoodIcon)

    @Update
    fun updateMoodIcon(icon: LocalMoodIcon)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    suspend fun insertMoodIcons(icons: List<LocalMoodIcon>): LongArray

}