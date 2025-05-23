package com.myapp.compose.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ScreenshotTestView() {
    Column(modifier = Modifier.background(Color.Green).padding(24.dp)) {
        Text(text = "Welcome")
        Text(text = "Check Slack message")
        Text(text = "Thanks for using my repo")
    }
}

@Preview
@Composable
fun ScreenshotTestViewNew() {
    Column(modifier = Modifier.background(Color.Red).padding(24.dp)) {
        Text(text = "Thanks for using my repo")
    }
}