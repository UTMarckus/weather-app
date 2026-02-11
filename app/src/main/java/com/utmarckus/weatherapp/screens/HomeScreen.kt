package com.utmarckus.weatherapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.utmarckus.weatherapp.R
import com.utmarckus.weatherapp.model.WeatherModel
import com.utmarckus.weatherapp.network.getWeatherData
import com.utmarckus.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun HomeScreen(contentPadding: PaddingValues = PaddingValues()) {
    val localContext = LocalContext.current

    val daysList = remember { mutableStateOf(listOf<WeatherModel>()) }
    val currentDay = remember { mutableStateOf(WeatherModel()) }

    val dialogState = remember { mutableStateOf(false) }
    if (dialogState.value)
        SearchDialogScreen(
            dialogState = dialogState,
            onSubmit = {
                getWeatherData(
                    city = it,
                    days = "7",
                    daysList = daysList,
                    currentDay = currentDay,
                    context = localContext
                )
            }
        )

    getWeatherData(
        city = "Bilokurakyne",
        days = "7",
        daysList = daysList,
        currentDay = currentDay,
        context = localContext
    )


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
        MainCard(
            currentDay = currentDay,
            onClickSearch = {
                dialogState.value = true
            },
            onClickSync = {
                getWeatherData(
                    city = "Bilokurakyne",
                    days = "7",
                    daysList = daysList,
                    currentDay = currentDay,
                    context = localContext
                )
            },
            modifier = Modifier.padding(top = 8.dp)
        )
        TabLayout(daysList, currentDay, modifier = Modifier.padding(top = 8.dp))
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    WeatherAppTheme() {
        HomeScreen()
    }
}
