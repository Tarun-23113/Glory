package com.example.glory.data.repository

import com.example.glory.data.model.Event
import kotlinx.coroutines.flow.Flow

class EventRepository(private val eventDao: EventDao) {

    val allEvents: Flow<List<Event>> = eventDao.getAllEvents()

    suspend fun insert(event: Event) = eventDao.insertEvent(event)

    suspend fun delete(event: Event) = eventDao.deleteEvent(event)

    suspend fun update(event: Event) = eventDao.updateEvent(event)

    fun getEventsBetweenDates(start: String, end: String): Flow<List<Event>> =
        eventDao.getEventsBetweenDates(start, end)
}
