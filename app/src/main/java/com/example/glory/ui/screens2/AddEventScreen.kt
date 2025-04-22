package com.example.glory.ui.screens2

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Celebration
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun AddEventScreen(
    navController: NavController,
    viewModel: AddEventViewModel = viewModel()
) {
    val state = viewModel.uiState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFFCE4EC), Color(0xFFFFF3E0))))
            .padding(16.dp)
    ) {
        Text("New Event", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Event Type", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold)

        EventTypeSelector(
            selected = state.eventType,
            onSelected = { viewModel.onEventTypeChanged(it) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = state.date,
            onValueChange = { viewModel.onDateChanged(it) },
            placeholder = { Text("Select Date") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = state.recipient,
            onValueChange = { viewModel.onRecipientChanged(it) },
            placeholder = { Text("Enter name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = state.message,
            onValueChange = { viewModel.onMessageChanged(it) },
            placeholder = { Text("Write your message...") },
            modifier = Modifier.fillMaxWidth().height(100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.saveEvent {
                    navController.navigate("flyer_preview")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6E6E))
        ) {
            Text("Preview Flyer", color = Color.White)
        }
    }
}

@Composable
fun EventTypeSelector(selected: String, onSelected: (String) -> Unit) {
    val types = listOf("Birthday", "Anniversary", "Festival", "Other")
    val icons = listOf(Icons.Default.Cake, Icons.Default.Favorite, Icons.Default.Celebration, Icons.Default.Event)

    Column {
        for (row in types.chunked(2).zip(icons.chunked(2))) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                row.first.forEachIndexed { index, type ->
                    OutlinedButton(
                        onClick = { onSelected(type) },
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (selected == type) Color(0xFFFFCDD2) else Color.Transparent
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    ) {
                        Icon(row.second[index], contentDescription = type, tint = Color.Red)
                        Spacer(Modifier.width(8.dp))
                        Text(type)
                    }
                }
            }
        }
    }
}

