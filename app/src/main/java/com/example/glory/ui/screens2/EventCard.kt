package com.example.glory.ui.screens2

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.glory.data.model.EventData


@Composable
fun EventCard(event: EventData, onPreview: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.LightGray, RoundedCornerShape(16.dp))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(event.eventType, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
            Text("To: ${event.recipient}", style = MaterialTheme.typography.bodyMedium)
            Text("On: ${event.date}", style = MaterialTheme.typography.bodySmall, color = Color.DarkGray)

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onPreview,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Preview Flyer", color = Color.White)
            }
        }
    }
}
