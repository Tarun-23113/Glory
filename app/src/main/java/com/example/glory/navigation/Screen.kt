package com.example.glory.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash")
    object WelcomeScreen : Screen("welcome")
    object LoginScreen : Screen("login")
    object SignupScreen : Screen("signup")
    object ColorPickerScreen : Screen("color_picker")
    object VibeScreen : Screen("vibe")
    object Welcome2 : Screen("signup_welcome")
    object Welcome3 : Screen("old_login")
    object HomePageScreen : Screen("HomePage")
    object EventListScreen : Screen("EventList")
    object AddEventScreen : Screen("Add_event")
    object EditFlyerScreen : Screen("edit_flyer")
    object ShareFlyerScreen : Screen("save_flyer")
    object ProfileViewEditScreen : Screen("Profile")
    // more layers will be added
}
