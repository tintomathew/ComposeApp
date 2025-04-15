package com.myapp.compose.ui.theme.detail

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.myapp.compose.navigation.Screens
import com.myapp.compose.navigation.onItemClick

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        GlideImage(
//            model = "https://www.shutterstock.com/image-vector/sample-red-square-grunge-stamp-260nw-338250266.jpg",
//            contentDescription = "",
//            modifier = Modifier.padding(24.dp),
//        )
        GifImage()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Detail Screen",
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            modifier = Modifier.clickable {
                onItemClick(navController, Screens.InitialScreen)
            },
            text = "Go To News",
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun GifImage() {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context)
                .data(data = "https://www.easygifanimator.net/images/samples/eglite.gif")
                .apply(block = {
                }).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
    )
}