package com.example.glory.ui.screens2

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.glory.data.model.Event
import com.example.glory.data.model.EventData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.*


open class EventListViewModel : ViewModel() {

    private val _events = MutableStateFlow<List<EventData>>(emptyList())
    open val events: MutableStateFlow<List<EventData>> = _events

    init {
        fetchEvents()
    }

    private fun fetchEvents() {
        Firebase.firestore.collection("events")
            .addSnapshotListener { snapshot, error ->
                if (error != null || snapshot == null) return@addSnapshotListener

                _events.value = snapshot.documents.mapNotNull { doc ->
                    doc.toObject(EventData::class.java)?.copy(id = doc.id)
                }
            }
    }
}
