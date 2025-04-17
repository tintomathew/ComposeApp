package com.myapp.compose.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feature_news.initialscreen.InitialScreen
import com.example.feature_news.initialscreen.InitialViewModel
import com.myapp.compose.main.MainViewModel
import com.myapp.compose.ui.screens.bottomsheet.NewModalBottomSheet
import com.myapp.compose.ui.screens.detail.DetailScreen
import com.myapp.compose.ui.screens.learnings.LearningScreen
import com.myapp.compose.ui.screens.restaurants.RestaurantScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination= Screens.Restaurant.route) {
        composable(Screens.Restaurant.route){
            RestaurantScreen(viewModel = hiltViewModel<MainViewModel>(), navController)
        }

        composable(Screens.Detail.route){
            DetailScreen(hiltViewModel<MainViewModel>(), navController)
        }

        composable(Screens.Learnings.route){
            LearningScreen()
        }

        composable(Screens.NewModalBottomSheet.route){
            NewModalBottomSheet()
        }

        composable(Screens.InitialScreen.route){
            InitialScreen(navController,  hiltViewModel<InitialViewModel>())
        }
    }
}

fun onItemClick(navController: NavHostController, screen: Screens) {
    when(screen){
        Screens.Detail -> navController.navigate(Screens.Detail.route)
        Screens.Restaurant -> navController.navigate(Screens.Restaurant.route)
        Screens.InitialScreen -> navController.navigate(Screens.InitialScreen.route)
        Screens.Learnings -> navController.navigate(Screens.Learnings.route)
        Screens.NewModalBottomSheet -> navController.navigate(Screens.NewModalBottomSheet.route)
    }
}