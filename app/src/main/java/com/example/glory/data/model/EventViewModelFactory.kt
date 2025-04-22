package com.example.glory.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.glory.data.repository.EventDao

class EventViewModelFactory(private val dao: EventDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EventViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
