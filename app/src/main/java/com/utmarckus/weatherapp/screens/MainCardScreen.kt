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
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.utmarckus.weatherapp.R
import com.utmarckus.weatherapp.model.WeatherModel
import com.utmarckus.weatherapp.ui.theme.BlueLight
import com.utmarckus.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun MainCard(
    currentDay: MutableState<WeatherModel>,
    onClickSearch: () -> Unit,
    onClickSync: () -> Unit,
    modifier: Modifier = Modifier
) {
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
                    text = currentDay.value.time,
                    fontSize = 16.sp,
                    color = Color.White
                )
                AsyncImage(
                    model = stringResource(
                        R.string.icon_link,
                        currentDay.value.conditionIcon
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }
            Text(
                text = currentDay.value.city,
                fontSize = 24.sp,
                color = Color.White
            )
            Text(
                text = if (currentDay.value.currentTemp.isEmpty()) {
                    stringResource(
                        R.string.max_min_temperature,
                        currentDay.value.maxTemp,
                        currentDay.value.minTemp
                        )
                } else {
                    stringResource(
                        R.string.current_temperature,
                        currentDay.value.currentTemp
                    )
                },
                fontSize = 56.sp,
                color = Color.White
            )
            Text(
                text = currentDay.value.conditionText,
                fontSize = 16.sp,
                color = Color.White
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { onClickSearch() },
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search),
                        tint = Color.White
                    )
                }
                Text(
                    text = stringResource(
                        R.string.max_min_temperature,
                        currentDay.value.maxTemp,
                        currentDay.value.minTemp
                    ),
                    fontSize = 16.sp,
                    color = Color.White
                )
                IconButton(
                    onClick = { onClickSync() },
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
        //MainCard()
    }
}
