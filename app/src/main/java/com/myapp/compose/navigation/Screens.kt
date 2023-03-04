package com.myapp.compose.navigation

sealed class Screens(val route: String) {
    object Home: Screens("home_screen")
    object Detail: Screens("Detail_screen")
    object Learnings: Screens("Learnings_screen")
}