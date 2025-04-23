package com.example.glory.ui.screens2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.glory.data.model.EventData
import com.example.glory.ui.theme.GloryTheme

import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.glory.navigation.Screen // adjust if your Screen file path differs

@Composable
fun HomePageScreen(
    navController: NavController,
    username: String = "Sarah",
    events: List<EventData>
) {
    val searchQuery by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                tonalElevation = 6.dp
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    BottomNavItem(icon = Icons.Outlined.Home, label = "Home", isSelected = true, modifier = Modifier.weight(1f))
                    BottomNavItem(icon = Icons.Outlined.CalendarToday, label = "Calendar", modifier = Modifier.weight(1f))
                    BottomNavItem(icon = Icons.Outlined.Add, label = "Create", modifier = Modifier.weight(1f))
                    BottomNavItem(icon = Icons.Outlined.Person, label = "Profile", modifier = Modifier.weight(1f))
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFFFFF1F1), Color.White)
                    )
                )
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Hello, $username", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = searchQuery,
                onValueChange = {},
                placeholder = { Text("Search events...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Row with View All Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Upcoming Events", fontWeight = FontWeight.Bold, fontSize = 16.sp)

                // 🧭 Navigation Button to Event List Screen
                Button(
                    onClick = {
                        navController.navigate(Screen.EventListScreen.route)
                    },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.height(40.dp)
                ) {
                    Text("View All", color = Color.White, fontWeight = FontWeight.Medium)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(events) { event ->
                    EventCard(event)
                }
            }
        }
    }
}

@Composable
fun EventCard(event: EventData) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFE4EE)),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(event.date, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(event.eventType, color = Color.Gray)
                Text(event.recipient, fontWeight = FontWeight.Medium)
            }

            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favorite",
                tint = Color.Red,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun BottomNavItem(
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
) {
    Column(
        modifier = modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(imageVector = icon, contentDescription = label, tint = if (isSelected) Color.Red else Color.Gray)
        Text(label, fontSize = 12.sp, color = if (isSelected) Color.Red else Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePageScreenPreview() {
    val sampleEvents = listOf(
        EventData(id = "1", recipient = "Alice", message = "Happy B-day!", date = "2025-05-01", eventType = "Birthday"),
        EventData(id = "2", recipient = "Bob", message = "Congrats!", date = "2025-05-02", eventType = "Anniversary")
    )

    GloryTheme {
        HomePageScreen(
            navController = rememberNavController(),
            username = "Sarah",
            events = sampleEvents
        )
    }
}
