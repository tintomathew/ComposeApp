package com.myapp.compose.navigation

sealed class Screens(val route: String) {
    object Dashboard: Screens("Dashboard_screen")
    object Restaurant: Screens("Restaurant_screen")
    object RestaurantDetails:Screens("restaurantDetails/{restaurantId}") {
        fun createRoute(restaurantId: String) = "restaurantDetails/$restaurantId"
    }
    object Detail: Screens("Detail_screen")
    object Learnings: Screens("Learnings_screen")
    object InitialScreen: Screens("Initial_Screen")
}