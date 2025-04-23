package com.example.glory.ui.screens2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.glory.data.model.EventData
import com.example.glory.navigation.Screen

@Composable
fun EventListScreenContent(
    events: List<EventData>,
    onPreview: (EventData) -> Unit,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFE0F7FA), Color(0xFFE8F5E9)))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text("Your Events", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        if (events.isEmpty()) {
            Text("No events yet. Tap + to add one!", color = Color.Gray)
        } else {
            LazyColumn {
                items(events) { event ->
                    EventCard(event = event) {
                        onPreview(event)
                        navController.navigate(Screen.EditFlyerScreen.route + "/${event.id}")
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        FloatingActionButton(
            onClick = { navController.navigate(Screen.AddEventScreen.route) },
            containerColor = Color(0xFF00796B),
            contentColor = Color.White,
            modifier = Modifier
                .align(Alignment.End)
                .padding(16.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add Event")
        }
    }
}

@Composable
fun EventCard(event: EventData, onPreview: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clickable(onClick = onPreview),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = event.recipient, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = event.message)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = event.date, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onPreview,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00796B)),
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Preview Flyer", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventListScreenPreview() {
    val sampleEvents = listOf(
        EventData(id = "1", recipient = "Alice", message = "Happy B-day!", date = "2025-05-01", type = "Birthday"),
        EventData(id = "2", recipient = "Bob", message = "Congrats!", date = "2025-05-02", type = "Anniversary")
    )

    EventListScreenContent(
        events = sampleEvents,
        onPreview = {},
        navController = rememberNavController()
    )
}
