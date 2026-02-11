package com.utmarckus.weatherapp.network

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.utmarckus.weatherapp.model.WeatherModel
import org.json.JSONArray
import org.json.JSONObject

const val API_KEY = "174c1c9a26a1424e8a971704260502"

internal fun getWeatherData(
    city: String,
    days: String,
    daysList: MutableState<List<WeatherModel>>,
    currentDay: MutableState<WeatherModel>,
    context: Context
) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=$API_KEY&q=$city&days=$days&aqi=no"

    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            getWeatherByDays(response).let {
                daysList.value = it
                currentDay.value = it[0]
            }
        },
        { Log.d("MyLog", "Volley Error: $it") }
    )
    queue.add(stringRequest)
}

private fun getWeatherByDays(response: String): List<WeatherModel> {
    if (response.isEmpty()) return listOf()

    val resultList = mutableListOf<WeatherModel>()
    val mainObject = JSONObject(response)
    val daysArr = mainObject.getJSONObject("forecast").getJSONArray("forecastday")

    for (i in 0 until daysArr.length()) {
        val day = daysArr[i] as JSONObject

        resultList.add(
            WeatherModel(
                city = mainObject.getJSONObject("location").getString("name"),
                time = if (i == 0) mainObject.getJSONObject("current")
                    .getString("last_updated") else day.getString("date"),
                currentTemp = if (i == 0) mainObject.getJSONObject("current")
                    .getString("temp_c") else "",
                conditionText = day.getJSONObject("day").getJSONObject("condition")
                    .getString("text"),
                conditionIcon = day.getJSONObject("day").getJSONObject("condition")
                    .getString("icon"),
                maxTemp = day.getJSONObject("day").getString("maxtemp_c"),
                minTemp = day.getJSONObject("day").getString("mintemp_c"),
                hours = day.getString("hour")
            )
        )
    }

    return resultList
}

internal fun getWeatherByHours(hours: String): List<WeatherModel> {
    if (hours.isEmpty()) return listOf()

    val resultList = mutableListOf<WeatherModel>()
    val hoursArr = JSONArray(hours)

    for (i in 0 until hoursArr.length()) {
        val item = hoursArr[i] as JSONObject

        resultList.add(
            WeatherModel(
                time = item.getString("time"),
                currentTemp = item.getString("temp_c"),
                conditionText = item.getJSONObject("condition").getString("text"),
                conditionIcon = item.getJSONObject("condition").getString("icon")
            )
        )
    }

    return resultList
}
