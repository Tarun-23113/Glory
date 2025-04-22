package com.example.glory.data.repository

import androidx.room.*
import com.example.glory.data.model.Event
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {

    @Query("SELECT * FROM event ORDER BY date")
    fun getAllEvents(): Flow<List<Event>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: Event)

    @Delete
    suspend fun deleteEvent(event: Event)

    @Update
    suspend fun updateEvent(event: Event)

    @Query("SELECT * FROM event WHERE date BETWEEN :start AND :end ORDER BY date")
    fun getEventsBetweenDates(start: String, end: String): Flow<List<Event>>
}
