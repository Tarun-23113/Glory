package com.example.glory.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import com.example.glory.navigation.Screen

//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.compose.rememberNavController

@Composable
fun ColorPickerScreen(navController: NavHostController) {
    val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Magenta)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pick a Color Theme", fontSize = 20.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            colors.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(color)
                        .clickable { navController.navigate(Screen.Vibe.route) }
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ColorPickerScreenPreview() {
//    ColorPickerScreen(
//        navController = rememberNavController()
//    )
//}
