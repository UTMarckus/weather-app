package com.utmarckus.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import com.utmarckus.weatherapp.screens.HomeScreen
import com.utmarckus.weatherapp.screens.MainCard
import com.utmarckus.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold() { innerPadding ->
                    HomeScreen(contentPadding = innerPadding)
                }
            }
        }
    }
}
