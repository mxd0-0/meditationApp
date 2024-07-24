package com.example.meditationapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.meditationapp.ui.theme.DeepBlue

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {
        Column {
            TopAppBar()


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {

    TopAppBar(colors = TopAppBarColors(
        containerColor = Color.Transparent,
        navigationIconContentColor = Color.Transparent,
        scrolledContainerColor =  Color.Transparent,
        titleContentColor = Color.White,
        actionIconContentColor = Color.White
    ), title = {
        Column {
            Text(text = "Hello, Moh")
            Text(text = "Happy Meditation")
        }
    })
}


@Preview
@Composable
private fun Preview() {
    HomeScreen()
}