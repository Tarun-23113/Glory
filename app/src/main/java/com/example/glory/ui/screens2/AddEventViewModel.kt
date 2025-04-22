package com.example.glory.ui.screens2

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.glory.data.model.AddEventUiState
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddEventViewModel : ViewModel() {

    var uiState by mutableStateOf(AddEventUiState())
        private set

    fun onEventTypeChanged(type: String) {
        uiState = uiState.copy(eventType = type)
    }

    fun onDateChanged(date: String) {
        uiState = uiState.copy(date = date)
    }

    fun onRecipientChanged(name: String) {
        uiState = uiState.copy(recipient = name)
    }

    fun onMessageChanged(msg: String) {
        uiState = uiState.copy(message = msg)
    }

    fun saveEvent(onSuccess: () -> Unit) {
        val db = Firebase.firestore
        val data = hashMapOf(
            "eventType" to uiState.eventType,
            "date" to uiState.date,
            "recipient" to uiState.recipient,
            "message" to uiState.message
        )
        db.collection("events")
            .add(data)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.e("AddEventViewModel", "Error saving", it) }
    }
}
