package com.myapp.compose.ui.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.myapp.compose.R
import com.myapp.compose.navigation.Screens
import com.myapp.compose.navigation.onItemClick
import com.myapp.compose.ui.screens.bottomsheet.BottomSheet

@Preview
@Composable
fun DashboardScreen(navHostController: NavHostController = NavHostController(LocalContext.current)) {
    var showSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        BottomSheet() {
            showSheet = false
        }
    }
    Scaffold() { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray),
                shape = RectangleShape,
                onClick = {
                    onItemClick(navHostController, Screens.Restaurant)
                }) {
                Text(text = stringResource(R.string.restaurant))
            }

            Button(modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray),
                shape = RectangleShape,
                onClick = {
                    onItemClick(navHostController, Screens.Learnings)
                }) {
                Text(stringResource(R.string.learnings))
            }

            Button(modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray),
                shape = RectangleShape,
                onClick = {
                    onItemClick(navHostController, Screens.Detail)
                }) {
                Text(stringResource(R.string.image_rendering))
            }

            Button(modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray),
                shape = RectangleShape,
                onClick = {
                    onItemClick(navHostController, Screens.InitialScreen)
                }) {
                Text(stringResource(R.string.news_module))
            }

            Button(modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray),
                shape = RectangleShape,
                onClick = {
                    showSheet = true
                }) {
                Text(stringResource(R.string.modal_bottomsheet))
            }
        }
    }
}