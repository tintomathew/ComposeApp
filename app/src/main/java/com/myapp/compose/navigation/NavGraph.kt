package com.myapp.compose.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.feature_news.initialscreen.InitialScreen
import com.example.feature_news.initialscreen.InitialViewModel
import com.myapp.compose.main.MainViewModel
import com.myapp.compose.ui.screens.dashboard.DashboardScreen
import com.myapp.compose.ui.screens.detail.DetailScreen
import com.myapp.compose.ui.screens.learnings.LearningScreen
import com.myapp.compose.ui.screens.restaurants.RestaurantDetailsScreen
import com.myapp.compose.ui.screens.restaurants.RestaurantScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Dashboard.route) {
        composable(Screens.Dashboard.route) {
            DashboardScreen(navController)
        }
        composable(Screens.Restaurant.route) {
            RestaurantScreen(viewModel = hiltViewModel<MainViewModel>(), navController)
        }

        composable(
            route = Screens.RestaurantDetails.route,
        ) {
            RestaurantDetailsScreen(navController)
        }

        composable(Screens.Detail.route) {
            DetailScreen(hiltViewModel<MainViewModel>(), navController)
        }

        composable(Screens.Learnings.route) {
            LearningScreen()
        }

        composable(Screens.InitialScreen.route) {
            InitialScreen(navController, hiltViewModel<InitialViewModel>())
        }
    }
}

fun onItemClick(navController: NavHostController, screen: Screens) {
    when (screen) {
        Screens.Dashboard -> navController.navigate(Screens.Dashboard.route)
        Screens.Detail -> navController.navigate(Screens.Detail.route)
        Screens.Restaurant -> navController.navigate(Screens.Restaurant.route)
        Screens.RestaurantDetails -> navController.navigate(Screens.RestaurantDetails.route)
        Screens.InitialScreen -> navController.navigate(Screens.InitialScreen.route)
        Screens.Learnings -> navController.navigate(Screens.Learnings.route)
    }
}