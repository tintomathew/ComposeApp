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
import com.myapp.compose.MainViewModel
import com.myapp.compose.SearchComponent
import com.myapp.compose.ui.theme.bottomsheet.NewModalBottomSheet
import com.myapp.compose.ui.theme.detail.DetailScreen
import com.myapp.compose.ui.theme.learnings.LearningScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination= Screens.Detail.route) {
        composable(Screens.Home.route){
            SearchComponent(viewModel = hiltViewModel<MainViewModel>(), navController)
        }

        composable(Screens.Detail.route){
            DetailScreen(navController)
        }

        composable(Screens.Learnings.route){
            LearningScreen()
        }

        composable(Screens.NewModalBottomSheet.route){
            NewModalBottomSheet()
        }

        composable(Screens.InitialScreen.route){
            InitialScreen(navController)
        }
    }
}

fun onItemClick(navController: NavHostController, screen: Screens) {
    when(screen){
        Screens.Detail -> navController.navigate(Screens.Detail.route)
        Screens.Home -> navController.navigate(Screens.Home.route)
        Screens.InitialScreen -> navController.navigate(Screens.InitialScreen.route)
        Screens.Learnings -> navController.navigate(Screens.Learnings.route)
        Screens.NewModalBottomSheet -> navController.navigate(Screens.NewModalBottomSheet.route)
    }
}