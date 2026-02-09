package com.utmarckus.weatherapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.utmarckus.weatherapp.R
import com.utmarckus.weatherapp.ui.theme.BlueLight
import com.utmarckus.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun ListItem(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = BlueLight),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column() {
                Text(
                    text = "12:00",
                )
                Text(
                    text = "Sunny",
                    color = Color.White,
                )
            }
            Text(
                text = stringResource(R.string.current_temperature, 25),
                fontSize = 24.sp,
                color = Color.White,
            )
            AsyncImage(
                model = "https://cdn.weatherapi.com/weather/64x64/day/116.png",
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    WeatherAppTheme(){
        ListItem()
    }
}
