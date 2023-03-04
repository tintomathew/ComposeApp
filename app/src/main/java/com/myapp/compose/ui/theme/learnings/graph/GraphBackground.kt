package com.myapp.compose.ui.theme.learnings.graph

import android.graphics.PointF
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.unit.dp
import java.math.BigDecimal
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Graphbackground() {
    Column() {
        Text(text = "This is my Compose Learning Screen")

        // Use Draw Scope for drawing
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .background(Color.White)
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(3 / 2f)
            ) {
                // Draw background rectangle
                drawRect(Color.Gray, style = Stroke(1.dp.toPx()))

                // Draw vertical lines inside it
                val verticalLines = 4
                val verticalSize = size.width / (verticalLines + 1)
                repeat(verticalLines) { i ->
                    val startX = verticalSize * (i + 1)
                    drawLine(
                        Color.Gray,
                        start = Offset(startX, 0f),
                        end = Offset(startX, size.height),
                        strokeWidth = 1.dp.toPx()
                    )

                }

                // Draw horizontal lines inside it
                val horizontalLines = 4
                val horizontalSize = size.height / (horizontalLines + 1)
                repeat(horizontalLines) { i ->
                    val startY = horizontalSize * (i + 1)
                    drawLine(
                        Color.Gray,
                        start = Offset(x = 0f, y = startY),
                        end = Offset(x = size.width, y = startY),
                        strokeWidth = 1.dp.toPx()
                    )
                              }
                // draw line
                val path = createPath(graphData, size)
                clipRect(right = size.width * 2) {
                    drawPath(path, Color.Green, style = Stroke(2.dp.toPx()))

                    // Responsible for adding gradient respect to the line
                    val filledPath = createPath(graphData, size)
                    filledPath.relativeLineTo(0f, size.height)
                    filledPath.lineTo(0f, size.height)
                    filledPath.close()
                    drawPath(
                        filledPath,
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Green.copy(alpha = 0.4f),
                                Color.Transparent
                            )
                        ),
                        style = Fill
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun createPath(data: List<Balance>, size: Size): Path {
    val path = Path()

    val numberEntries = data.size - 1               // Number of entries in the list
    val weekWidth = size.width / numberEntries      // Total width of the graph / no of entries

    val max = data.maxBy { it.amount }
    val min = data.minBy { it.amount }              // will map to x= 0, y = height
    val range = max.amount - min.amount
    Log.d(":::$max", "::" + range.toFloat())
    Log.d("Size:::$min", "::" + size.height)
    val heightPxPerAmount = size.height / range.toFloat()

    var previousBalanceX = 0f
    var previousBalanceY = size.height

    data.forEachIndexed { i, balance ->
        val balanceY = size.height - (balance.amount - min.amount).toFloat() *         // Common
                heightPxPerAmount
        if (i == 0) {
            path.moveTo(
                0f,
                balanceY
            )
        }
        val balanceX = i * weekWidth              // common for all X
        //path.lineTo(balanceX, balanceY)


        // to do smooth curve graph - we use cubicTo, uncomment section below for non-curve
        val controlPoint1 = PointF((balanceX + previousBalanceX) / 2f, previousBalanceY)
        val controlPoint2 = PointF((balanceX + previousBalanceX) / 2f, balanceY)
        path.cubicTo(
            controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y,
            balanceX, balanceY
        )

        previousBalanceX = balanceX
        previousBalanceY = balanceY
    }
    return path
}

// date + balance
// list of date + balanc
@RequiresApi(Build.VERSION_CODES.O)
val graphData = listOf(
    Balance(LocalDate.now(), BigDecimal(65631)),
    Balance(LocalDate.now().plusWeeks(1), BigDecimal(75931)),
    Balance(LocalDate.now().plusWeeks(2), BigDecimal(65851)),
    Balance(LocalDate.now().plusWeeks(3), BigDecimal(65931)),
    Balance(LocalDate.now().plusWeeks(4), BigDecimal(66484)),
    Balance(LocalDate.now().plusWeeks(5), BigDecimal(67684)),
    Balance(LocalDate.now().plusWeeks(13), BigDecimal(73589)),
    Balance(LocalDate.now().plusWeeks(6), BigDecimal(66684)),
    Balance(LocalDate.now().plusWeeks(7), BigDecimal(66984)),
    Balance(LocalDate.now().plusWeeks(8), BigDecimal(70600)),
    Balance(LocalDate.now().plusWeeks(9), BigDecimal(71600)),
    Balance(LocalDate.now().plusWeeks(10), BigDecimal(72600)),
    Balance(LocalDate.now().plusWeeks(11), BigDecimal(72526)),
    Balance(LocalDate.now().plusWeeks(12), BigDecimal(72976)),
)

data class Balance(val date: LocalDate, val amount: BigDecimal)