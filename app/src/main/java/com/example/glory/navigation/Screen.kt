package com.example.glory.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object Signup : Screen("signup")
    object ColorPicker : Screen("color_picker")
    object Vibe : Screen("vibe")
    object Welcome2 : Screen("signup_welcome")
    object Welcome3 : Screen("old_login")
    // more layers will be added
}
