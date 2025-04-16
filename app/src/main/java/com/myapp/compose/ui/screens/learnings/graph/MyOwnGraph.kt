package com.myapp.compose.ui.screens.learnings.graph

import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp

@Composable
fun MyOwnGraph(xValues: List<Int>, yValues: List<Int>, points: List<Int>) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
            // Draw Y axis line
            drawContext.canvas.nativeCanvas.drawLine(
                0f,
                0f,
                0f,
                size.height,
                Paint(Color.Black.hashCode())
            )

            // Draw X axis line
            drawContext.canvas.nativeCanvas.drawLine(
                0f,
                size.height,
                size.width,
                size.height,
                Paint(Color.Black.hashCode())
            )

            val interval = (yValues.max() - yValues.min()) / yValues.size
            val yAxisSize = size.height / yValues.size + (yValues.size / yValues.max())

            for (i in yValues.indices) {
                drawContext.canvas.nativeCanvas.drawText(
                    "${yValues[i]}",
                    0f,
                    size.height - (yAxisSize * (i+1)),
                    Paint(Color.Black.hashCode())
                )
            }

            val xAxisSize = size.width / yValues.size
            for (i in xValues.indices) {
                Log.d("AAA:BB:", "XXXX::"+ xAxisSize + (i * xAxisSize))
                drawContext.canvas.nativeCanvas.drawText(
                    "${xValues[i]}",
                    xAxisSize + (i * xAxisSize),
                    size.height,
                    Paint(Color.Black.hashCode())
                )
            }


            val max = yValues.max()
            val min = yValues.min()            // will map to x= 0, y = height
            val range = max - min
            Log.d(":::$max", "::" + range.toFloat())
            Log.d("Size:::$min", "::" + size.height)
            val heightPxPerAmount = size.height / range.toFloat()
            /** placing points */
            for (i in points.indices) {
                val x1 = xAxisSize + (i * xAxisSize)

                val y1 = size.height - (points[i] - min).toFloat() * heightPxPerAmount

                Log.d("XXX:::"+y1,"::"+x1)
                /** drawing circles to indicate all the points */
                drawCircle(
                    color = Color.Red,
                    radius = 10f,
                    center = Offset(x1,y1)
                )
            }
        })
    }
}