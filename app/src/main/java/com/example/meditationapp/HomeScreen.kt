package com.example.meditationapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meditationapp.ui.theme.ButtonBlue
import com.example.meditationapp.ui.theme.DarkerButtonBlue
import com.example.meditationapp.ui.theme.DeepBlue
import com.example.meditationapp.ui.theme.LightRed
import com.example.meditationapp.ui.theme.TextWhite

//need to adjust colors 
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {
        Column {
            TopAppBar()
            ChipSection(chipTexts = listOf("All", "Favorites"))
            CurrentMeditation()
            Featured(
                feature = listOf(
                    Feature(
                        title = "Hamza 15 min",
                        R.drawable.ic_headphone,
                        Color(0xff0061ff),
                        Color(0xff60efff),

                        ), Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        Color(0xff00ff87),
                        Color(0xff60efff),

                        ), Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        Color(0xff9fccfa),
                        Color(0xff0974f1),

                        ), Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Color(0xff8de9d5),
                        Color(0xff32c4c0),

                        )
                )
            )


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    TopAppBar(modifier = Modifier.padding(15.dp), colors = TopAppBarColors(
        containerColor = Color.Transparent,
        navigationIconContentColor = Color.Transparent,
        scrolledContainerColor = Color.Transparent,
        titleContentColor = Color.White,
        actionIconContentColor = Color.White
    ), title = {
        Column {
            Text(
                text = "Hello, Moh",
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = "Happy Meditation", style = MaterialTheme.typography.titleMedium
            )
        }
    }, actions = {
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )

        }
    })
}

@Composable
fun ChipSection(chipTexts: List<String>) {
    LazyRow {
        items(chipTexts.size) { index ->
            Chip(chipTxt = chipTexts[index])
        }
    }
}

@Composable
fun CurrentMeditation() {
    Row(
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(LightRed)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(15.dp), horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.titleMedium,
                color = TextWhite
            )
            Text(
                text = "Meditation 3-5 min",
                style = MaterialTheme.typography.titleMedium,
                color = TextWhite
            )
        }
        IconButton(onClick = { }, modifier = Modifier.padding(10.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun Chip(chipTxt: String) {
    var selected by remember {
        mutableStateOf(false)
    }
    FilterChip(modifier = Modifier.padding(start = 15.dp, top = 15.dp, bottom = 15.dp),
        onClick = { selected = !selected },

        selected = selected,
        label = { Text(text = chipTxt, color = TextWhite) },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = ButtonBlue,
            containerColor = DarkerButtonBlue,
        ),
        border = FilterChipDefaults.filterChipBorder(enabled = false, selected = false),
        shape = RoundedCornerShape(10.dp),
        leadingIcon = {
            if (selected) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    tint = Color.White,
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )

            }
        })
}

@Composable
fun Featured(feature: List<Feature>) {
    Text(
        text = "Featured",
        style = MaterialTheme.typography.titleLarge,
        color = TextWhite,
        modifier = Modifier.padding(15.dp)
    )
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(feature.size) {
            TheCard(feature = feature[it])
        }
    }

}

@Composable
fun TheCard(feature: Feature) {
    val brush = Brush.linearGradient(
        colors = listOf(
            feature.lightColor, feature.mediumColor
        )
    )


//End
    Card(
        modifier = Modifier
            .size(height = 200.dp, width = 190.dp)
            .padding(start = 15.dp, bottom = 15.dp, end = 15.dp)

    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush)
                .padding(8.dp)
        ) {


            Text(
                text = feature.title,
                style = MaterialTheme.typography.titleLarge,
                color = TextWhite,

                modifier = Modifier.align(
                    Alignment.TopCenter
                )
            )

            IconButton(
                onClick = { }, modifier = Modifier.align(Alignment.BottomStart)
            ) {
                Icon(
                    painter = painterResource(id = feature.iconId),
                    contentDescription = null,
                    tint = TextWhite,
                    modifier = Modifier
                )
            }
            Button(
                onClick = { },
                modifier = Modifier.align(Alignment.BottomEnd),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonBlue

                )
            ) {
                Text(text = "Start")

            }
        }

    }
}


@Preview
@Composable
private fun Preview() {
    HomeScreen()
}