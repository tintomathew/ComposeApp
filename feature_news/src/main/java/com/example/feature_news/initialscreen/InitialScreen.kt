package com.example.feature_news.initialscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

@Composable
fun InitialScreen(navController: NavHostController, initialViewModel: InitialViewModel) {

    Scaffold() { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(contentPadding)
                .verticalScroll(rememberScrollState())
        ) {
            NewsItem(initialViewModel)
        }
    }
}


@Composable
fun NewsItem(initialViewModel: InitialViewModel) {
    // Example image URL (replace with actual URLs)
    val imageUrl = initialViewModel.getImageUrl()

    Column {
        // Image loaded from URL using Coil
        Image(
            painter = rememberAsyncImagePainter(imageUrl),  // Coil image loader for URL
            contentDescription = "News Image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .height(200.dp),
            contentScale = ContentScale.Fit

        )

        // Title and Summary
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Breaking News: Amazing Headline",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "This is a brief summary of the news item. It gives a sneak peek of the full article.",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
            )
        }
    }
}