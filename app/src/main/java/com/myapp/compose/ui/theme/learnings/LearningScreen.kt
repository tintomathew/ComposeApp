package com.myapp.compose.ui.theme.learnings

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import com.myapp.compose.ui.theme.learnings.graph.Graphbackground
import com.myapp.compose.ui.theme.learnings.graph.MyOwnGraph

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LearningScreen() {
    val yValues = listOf(15000, 16000, 17000, 18000, 19000,20000)
    val xValues = listOf(2012, 2013, 2014, 2015, 2016, 2017, 2018)
    val points = listOf(15500, 17000, 19000, 15900, 16500, 15200)
    Graphbackground()
    //MyOwnGraph(xValues, yValues, points)
}