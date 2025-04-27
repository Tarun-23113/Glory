package com.example.glory.ui.screens

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import com.example.glory.R
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.glory.navigation.Screen

@Composable
fun SplashScreen(navController: NavController) {
    val isInPreview = LocalInspectionMode.current

    val logo = painterResource(R.drawable.resizedimage)

    var visible by remember { mutableStateOf(false) }

    val alphaAnim by animateFloatAsState(
        targetValue = if (visible || isInPreview) 1f else 0f,
        animationSpec = tween(durationMillis = 4000),
        label = "splashAlpha"
    )

    LaunchedEffect(Unit){
        visible = true
        delay(2000)
        navController.navigate(Screen.WelcomeScreen.route) {
            popUpTo(Screen.SplashScreen.route) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF090909)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = logo,
            contentDescription = "App Logo",
            modifier = Modifier
                .size(if (isInPreview) 1000.dp else 1000.dp)
                .alpha(alphaAnim)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    val navController = rememberNavController()
    SplashScreen(navController = navController)
}
