package com.example.feature_news.initialscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InitialScreen(navController: NavHostController, initialViewModel: InitialViewModel) {
    LaunchedEffect(Unit) {
        initialViewModel.getStringResource()
    }
    Scaffold(
        topBar = {
            MediumTopAppBar(title =
            { Text(text = "News") },
                navigationIcon = {})
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(contentPadding)
                .verticalScroll(rememberScrollState())
        ) {
            repeat(100) {
                Text("Coming soon....", color = Color.Black)
            }
        }
    }
}