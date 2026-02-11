package com.utmarckus.weatherapp.model

data class WeatherModel(
    val city: String = "",
    val time: String = "",
    val conditionText: String = "",
    val conditionIcon: String = "",
    val currentTemp: String = "",
    val maxTemp: String = "",
    val minTemp: String = "",
    val hours: String = "",
)
