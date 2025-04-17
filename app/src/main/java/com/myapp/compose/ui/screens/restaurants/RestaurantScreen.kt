package com.myapp.compose.ui.screens.restaurants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import com.myapp.compose.R
import com.myapp.compose.main.MainViewModel
import com.myapp.compose.navigation.Screens
import com.myapp.compose.navigation.onItemClick
import com.myapp.compose.ui.views.RestaurantList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantScreen(viewModel: MainViewModel, navController: NavHostController) {

    val state by viewModel.state.collectAsState()
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold() { contentPadding ->
        Column(
            Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(contentPadding)) {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                    viewModel.getRestaurants(text.text)
                },
                Modifier
                    .background(color = Color.Transparent)
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = stringResource(R.string.search_text),
                        style = MaterialTheme.typography.bodySmall
                    )
                },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            )
            RestaurantList(
                state
            ) { onItemClick(navController, Screens.Restaurant) }
        }
    }
}