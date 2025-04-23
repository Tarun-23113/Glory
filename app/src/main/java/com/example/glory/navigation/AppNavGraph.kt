package com.example.glory.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glory.navigation.Screen.EventListScreen
import com.example.glory.ui.screens.*
import com.example.glory.ui.screens2.AddEventScreen
import com.example.glory.ui.screens2.EditFlyerScreen
import com.example.glory.ui.screens2.EventListScreenContent

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        // splash screen
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }

        // welcome screen
        composable(Screen.Welcome.route) {
            WelcomeScreen(navController)
        }

        // login screen
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        // signup screen
        composable(Screen.Signup.route) {
            SignupScreen(navController)
        }

        // color sicker screen
        composable(Screen.ColorPicker.route) {
            ColorPickerScreen(navController)
        }

        // vibe selection screen
        composable(Screen.Vibe.route) {
            VibeScreen(navController)
        }

        //welcome screens on account creation
        composable(Screen.Welcome2.route) {
            WelcomeSignup(name = "Lucifer", navController = navController)
        }

        //welcome screen on login
        composable(Screen.Welcome3.route) {
            WelcomeLogin(name = "Lucifer", navController = navController)
        }

        //event adding screen
        composable(Screen.AddEventScreen.route) {
            AddEventScreen(navController = navController)
        }

        //editing auto generated flyer
        composable("edit_flyer") {
            EditFlyerScreen(navController = navController)
        }

        composable("event_list") {
            EventListScreenContent(
                navController = navController,
                events = TODO(),
                onAddEvent = TODO(),
                onPreview = TODO()
            )
        }

    }
}
