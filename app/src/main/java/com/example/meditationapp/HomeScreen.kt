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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meditationapp.ui.theme.ButtonBlue
import com.example.meditationapp.ui.theme.DarkerButtonBlue
import com.example.meditationapp.ui.theme.DeepBlue
import com.example.meditationapp.ui.theme.LightRed
import com.example.meditationapp.ui.theme.TextWhite

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {
        Column {
            TopAppBar()
            ChipSection(chipTexts = listOf("All", "Favorites"))
            CurrentMeditation()


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {

    TopAppBar(modifier = Modifier.padding(15.dp), colors = TopAppBarColors(
        containerColor = Color.Transparent,
        navigationIconContentColor = Color.Transparent,
        scrolledContainerColor = Color.Transparent,
        titleContentColor = Color.White,
        actionIconContentColor = Color.White
    ), title = {
        Column {
            Text(
                text = "Hello, Moh", style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Happy Meditation", style = MaterialTheme.typography.titleMedium
            )
        }
    }, actions = {
        IconButton(onClick = { /*TODO*/ }) {
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
fun ChipSection(chipTexts: List<String>, modifier: Modifier = Modifier) {

    LazyRow {
        items(chipTexts.size) { index ->
            Chip(chipTxt = chipTexts[index])
        }


    }


}

@Composable
fun CurrentMeditation(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(LightRed)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f).padding(15.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Daily Thought", style = MaterialTheme.typography.titleMedium, color = TextWhite
            )
            Text(
                text = "Meditation 3-5 min", style = MaterialTheme.typography.titleMedium, color = TextWhite
            )
        }
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(10.dp)) {
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
fun Chip(chipTxt: String, modifier: Modifier = Modifier) {
    var selected by remember {
        mutableStateOf(false)

    }

    FilterChip(
        modifier = Modifier.padding(start = 15.dp, top = 15.dp, bottom = 15.dp),
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(text = chipTxt, color = TextWhite) },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = ButtonBlue,
            containerColor = DarkerButtonBlue,

            ),
        border = FilterChipDefaults.filterChipBorder(enabled = false, selected = false),
        shape = RoundedCornerShape(10.dp)


    )

}


@Preview
@Composable
private fun Preview() {
    HomeScreen()
}