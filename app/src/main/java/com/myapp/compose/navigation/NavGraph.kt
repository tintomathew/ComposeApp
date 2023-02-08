package com.myapp.compose.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myapp.compose.MainViewModel
import com.myapp.compose.SearchComponent
import com.myapp.compose.ui.theme.detail.DetailScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination= Screens.Home.route) {
        composable(Screens.Home.route){
            SearchComponent(viewModel = hiltViewModel<MainViewModel>(), navController)
        }

        composable(Screens.Detail.route){
            DetailScreen()
        }
    }
}

fun onItemClick(navController: NavHostController) {
    navController.navigate(Screens.Detail.route)
}