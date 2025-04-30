package com.myapp.compose.ui.screens.restaurants

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.myapp.compose.main.MainViewModel
import com.myapp.compose.navigation.Screens

@SuppressLint("SuspiciousIndentation", "UnrememberedGetBackStackEntry")
@Composable
fun RestaurantDetailsScreen(navController: NavHostController) {

    val parentEntry = remember { navController.getBackStackEntry(Screens.Restaurant.route) }
    val viewModel = hiltViewModel<MainViewModel>(parentEntry)

    RestaurantDetailsScreen(
        imageUrl = viewModel.selectedRestaurant?.LogoUrl.toString(),
        name = viewModel.selectedRestaurant?.Name.toString(),
        description = viewModel.selectedRestaurant?.Description.toString(),
        rating = viewModel.selectedRestaurant?.RatingAverage ?: 0.0,
        location = viewModel.selectedRestaurant?.Address?.FirstLine.toString() + "\n" +
                viewModel.selectedRestaurant?.Address?.City.toString() + "\n" +
                viewModel.selectedRestaurant?.Address?.Postcode.toString()

    )
}

@Composable
fun RestaurantDetailsScreen(
    imageUrl: String,
    name: String,
    description: String,
    rating: Double,
    location: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "$name Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = name, fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Text(text = "Location:", fontSize = 16.sp)
            Text(text = location, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Rating: $rating ⭐", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = description, fontSize = 14.sp)
    }
}