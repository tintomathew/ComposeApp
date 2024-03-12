package com.myapp.compose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import com.myapp.compose.navigation.NavGraph
import com.myapp.compose.navigation.onItemClick
import com.myapp.compose.ui.theme.ComposeAppTheme
import com.myapp.compose.ui.theme.components.AppItems
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ComposeAppTheme() {
                NavGraph()


//                AlignmentLearnings()()
                //ScaffoldLearnings()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchComponent(viewModel: MainViewModel, navController: NavHostController) {

    val state by viewModel.state.collectAsState()
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Column {
        TextField(
            value = text,
            onValueChange = {
                text = it
                viewModel.getRestaurants(text.text)
            },
            Modifier
                .background(color = Color.Transparent)
                .fillMaxWidth(),
            placeholder = { Text(text = stringResource(R.string.search_text),
            style = MaterialTheme.typography.bodySmall) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null)},
        )
//        NavGraph()
        AppItems(
            state
        ) { onItemClick(navController) }
    }
}