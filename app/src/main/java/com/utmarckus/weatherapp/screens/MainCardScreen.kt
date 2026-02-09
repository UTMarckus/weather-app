package com.utmarckus.weatherapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun MainCard(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = BlueLight),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 12.dp)
            ) {
                Text(
                    text = "7 Feb 2026 16:00",
                    fontSize = 16.sp,
                    color = Color.White
                )
                AsyncImage(
                    model = "https://cdn.weatherapi.com/weather/64x64/day/116.png",
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }
            Text(
                text = "Madrid",
                fontSize = 24.sp,
                color = Color.White
            )
            Text(
                text = stringResource(R.string.current_temperature, 24),
                fontSize = 64.sp,
                color = Color.White
            )
            Text(
                text = "Sunny",
                fontSize = 16.sp,
                color = Color.White
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search),
                        tint = Color.White
                    )
                }
                Text(
                    text = stringResource(R.string.max_min_temperature, 25, 15),
                    fontSize = 16.sp,
                    color = Color.White
                )
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = stringResource(R.string.refresh),
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainCardPreview() {
    WeatherAppTheme() {
        MainCard()
    }
}
