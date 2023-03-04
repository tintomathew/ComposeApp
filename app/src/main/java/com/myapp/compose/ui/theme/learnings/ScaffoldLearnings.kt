package com.myapp.compose.ui.theme.learnings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldLearnings() {
    Scaffold(topBar = {}, bottomBar = {}) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding)) {
            Text(text = "Welcome")
        }
    }
}