package com.utmarckus.weatherapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.utmarckus.weatherapp.R
import com.utmarckus.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun HomeScreen(contentPadding: PaddingValues = PaddingValues()) {
    Image(
        painterResource(R.drawable.wallpaper_clouds),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.5f)
    )
    Column(
        modifier = Modifier
            .padding(contentPadding)
            .padding(horizontal = 8.dp)
    ) {
        MainCard(modifier = Modifier.padding(top = 8.dp))
        TabLayout(modifier = Modifier.padding(top = 8.dp))
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    WeatherAppTheme() {
        HomeScreen()
    }
}
