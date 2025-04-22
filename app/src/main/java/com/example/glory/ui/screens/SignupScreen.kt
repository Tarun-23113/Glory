package com.example.glory.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.glory.navigation.Screen
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.compose.rememberNavController

@Composable
fun SignupScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFB3FFAB), Color(0xFF12FFF7))))
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome, User", fontSize = 24.sp)
        listOf("Full Name", "Email", "Phone", "Create Password", "Confirm Password").forEach {
            OutlinedTextField(value = "", onValueChange = {}, label = { Text(it) })
            Spacer(modifier = Modifier.height(8.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate(Screen.ColorPicker.route) }) {
            Text("Sign up")
        }
        TextButton(onClick = { navController.navigate(Screen.Login.route) }) {
            Text("Already have an account? Login")
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun SignupScreenPreview() {
//    val mockNavController = rememberNavController()
//
//    MaterialTheme {
//        SignupScreen(navController = mockNavController)
//    }
//}