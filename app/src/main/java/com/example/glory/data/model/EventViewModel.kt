package com.example.glory.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.glory.data.model.Event
import com.example.glory.data.repository.EventDao
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class EventViewModel(private val eventDao: EventDao) : ViewModel() {

    val allEvents: StateFlow<List<Event>> = eventDao.getAllEvents()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addEvent(event: Event) {
        viewModelScope.launch {
            eventDao.insertEvent(event)
        }
    }

    fun deleteEvent(event: Event) {
        viewModelScope.launch {
            eventDao.deleteEvent(event)
        }
    }

    fun updateEvent(event: Event) {
        viewModelScope.launch {
            eventDao.updateEvent(event)
        }
    }

    fun getEventsBetween(start: String, end: String): Flow<List<Event>> {
        return eventDao.getEventsBetweenDates(start, end)
    }
}
