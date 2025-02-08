package com.myapp.compose.ui.theme.learnings

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldLearnings() {
    Scaffold(topBar = { Text(text = "Header")}, bottomBar = {
        Text(text = "Testing")
    }) { contentPadding ->
        // Screen content
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.padding(contentPadding).verticalScroll(scrollState)) {
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "Welcome")
            Text(text = "END")
        }

        if (scrollState.isScrollInProgress){
            Log.d("scrolling","in progress")
        }
    }
}