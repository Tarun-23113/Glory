package com.example.glory.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glory.data.model.EventData
import com.example.glory.data.model.User
import com.example.glory.ui.screens.*
import com.example.glory.ui.screens2.AddEventScreen
import com.example.glory.ui.screens2.EditFlyerScreen
import com.example.glory.ui.screens2.EventListScreenContent
import com.example.glory.ui.screens2.HomePageScreen
import com.example.glory.ui.screens2.ProfileViewEditScreen
import com.example.glory.ui.screens2.ShareFlyerScreen
import com.example.glory.ui.screens.LoginScreen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        // splash screen
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController)
        }

        // welcome screen
        composable(Screen.WelcomeScreen.route) {
            WelcomeScreen(navController)
        }

        // login screen
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController)
        }

        // signup screen
        composable(Screen.SignupScreen.route) {
            SignupScreen(navController)
        }

        // color sicker screen
        composable(Screen.ColorPickerScreen.route) {
            ColorPickerScreen(navController)
        }

        // vibe selection screen
        composable(Screen.VibeScreen.route) {
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

        //Home Screen
        composable(Screen.HomePageScreen.route) {
            // Define your event list here
            val yourEventList = listOf(
                EventData(id = "1", recipient = "Alice", message = "Happy B-day!", date = "2025-05-01", eventType = "Birthday"),
                EventData(id = "2", recipient = "Bob", message = "Congrats!", date = "2025-05-02", eventType = "Anniversary")
            )

            // Pass the event list to HomePageScreen
            HomePageScreen(
                navController = navController,
                username = "Sarah", // Or any username you'd like to use
                events = yourEventList
            )
        }

        //Event List Screen
        composable(Screen.EventListScreen.route) {
            EventListScreenContent(
                navController = navController,
                events = TODO(),
                onPreview = TODO()
            )
        }

        //event adding screen
        composable(Screen.AddEventScreen.route) {
            AddEventScreen(navController = navController)
        }

        //editing auto generated flyer
        composable(Screen.EditFlyerScreen.route) {
            EditFlyerScreen(navController = navController)
        }

        composable(Screen.ShareFlyerScreen.route){
            ShareFlyerScreen(
                navController = navController,
                flyerImageUrl = TODO(),
                onBack = TODO()
            )
        }

        composable(Screen.ProfileViewEditScreen.route) {
            ProfileViewEditScreen(
                user = User("John Doe", "john@example.com", ""),
                onSaveProfile = { updatedUser ->
                    // Handle save action
                },
                onLogout = {
                    // Handle logout action
                    navController.navigate(Screen.LoginScreen.route) {
                        popUpTo(Screen.ProfileViewEditScreen.route) { inclusive = true }
                    }
                }
            )
        }

    }
}
