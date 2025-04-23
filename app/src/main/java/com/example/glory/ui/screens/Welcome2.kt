package com.example.glory.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.glory.navigation.Screen
import com.example.glory.ui.theme.GloryTheme


@Composable
fun WelcomeSignup(name: String = "Lucifer", navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF00F2FE), Color(0xFF4FACFE))
                )
            )
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Emoji Starburst Graphic (You can replace this with an Image if you have an asset)
            Text("✨🌟😊🌟✨", fontSize = 36.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Welcome, $name",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Your data has officially been sold to aliens...",
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Just kidding. You're safe. We pinky promise",
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                "“You are now... Pixel Sorcerer Level 1 🧙‍♂️✨”",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {navController.navigate(Screen.HomePageScreen.route)},
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    "“Still confused? Take a tour” →",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun WelcomeSignupPreview() {
    GloryTheme {
        WelcomeSignup(name = "Lucifer", rememberNavController())
    }
}
