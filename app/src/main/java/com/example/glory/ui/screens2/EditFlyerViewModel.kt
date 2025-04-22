package com.example.glory.ui.screens2

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EditFlyerViewModel : ViewModel() {

    var uiState by mutableStateOf(EditFlyerUiState())
        private set

    fun onRecipientChanged(name: String) {
        uiState = uiState.copy(recipient = name)
    }

    fun onMessageChanged(msg: String) {
        uiState = uiState.copy(message = msg)
    }

    fun onRegenerateFlyer() {
        // TODO: call AI image generation API or Firebase Cloud Function
        Log.d("EditFlyer", "Regenerating flyer with new data...")
    }

    fun saveEditedFlyer() {
        val db = Firebase.firestore
        val updatedData = hashMapOf(
            "recipient" to uiState.recipient,
            "message" to uiState.message
        )
        db.collection("events").document(uiState.eventId)
            .update(updatedData as Map<String, Any>)
            .addOnSuccessListener { Log.d("EditFlyer", "Flyer updated") }
            .addOnFailureListener { Log.e("EditFlyer", "Update failed", it) }
    }
}
