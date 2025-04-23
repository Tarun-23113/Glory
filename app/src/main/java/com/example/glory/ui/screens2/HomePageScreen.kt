package com.example.glory.ui.screens2

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.glory.data.model.EventData
import com.example.glory.ui.theme.GloryTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageScreen(
    events: List<EventData>,
    onEditEvent: (EventData) -> Unit,
    onDeleteEvent: (EventData) -> Unit
) {
    var isLoading by remember { mutableStateOf(true) }
    var eventList by remember { mutableStateOf(events) }
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    // Simulate loading
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            delay(2000)
            isLoading = false
        }
    }

    val filteredEvents = eventList.filter { event ->
        event.recipient.contains(searchQuery.text, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        placeholder = { Text("Search by recipient") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(filteredEvents.size) { index ->
                        EventItem(
                            event = filteredEvents[index],
                            onEditClick = { onEditEvent(filteredEvents[index]) },
                            onDeleteClick = { onDeleteEvent(filteredEvents[index]) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EventItem(
    event: EventData,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = event.recipient, style = MaterialTheme.typography.titleMedium)
            Text(text = "Date: ${event.date}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Message: ${event.message}", style = MaterialTheme.typography.bodyMedium)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Button(onClick = onEditClick) {
                    Text("Edit")
                }
                Button(onClick = onDeleteClick) {
                    Text("Delete")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomePageScreen() {
    GloryTheme {
        HomePageScreen(
            events = listOf(
                EventData(
                    id = "1",
                    eventType = "Birthday",
                    date = "2025-04-25",
                    recipient = "Alice",
                    message = "Happy Birthday!",
                    type = "Personal"
                ),
                EventData(
                    id = "2",
                    eventType = "Anniversary",
                    date = "2025-05-01",
                    recipient = "Bob & Jane",
                    message = "Happy Anniversary!",
                    type = "Personal"
                )
            ),
            onEditEvent = {},
            onDeleteEvent = {}
        )
    }
}
