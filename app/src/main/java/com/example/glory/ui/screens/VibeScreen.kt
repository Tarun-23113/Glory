package com.example.glory.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.glory.navigation.Screen

@Composable
fun VibeScreen(navController: NavHostController) {
    val vibes = listOf("Pastel", "Bold", "Festive", "Minimalist")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pick a Vibe 🎨", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        vibes.forEach { vibe ->
            Button(onClick = { navController.navigate(Screen.Welcome2.route) }) {
                Text(text = vibe)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VibeScreenPreview() {
    VibeScreen(
        navController = rememberNavController()
    )
}