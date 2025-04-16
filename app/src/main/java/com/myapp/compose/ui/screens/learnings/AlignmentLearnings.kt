package com.myapp.compose.ui.screens.learnings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AlignmentLearnings() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "First")
            }
            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Second")
            }
            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Third")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {}, modifier = Modifier.weight(1f)) {
                Text(text = "First")
            }
            Button(onClick = {}, modifier = Modifier.weight(1f)) {
                Text(text = "Second")
            }
            Button(onClick = {}, modifier = Modifier.weight(1f)) {
                Text(text = "Third")
            }
        }
    }
    // Box can be used to show layout on top of another
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
    ) {
        Text(text = "Middle Man")
    }
}