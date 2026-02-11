package com.utmarckus.weatherapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.utmarckus.weatherapp.R

@Composable
fun SearchDialogScreen(
    dialogState: MutableState<Boolean>,
    onSubmit: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var cityName by remember { mutableStateOf("") }

    AlertDialog(
        title = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.enter_city))
                TextField(
                    value = cityName,
                    onValueChange = { cityName = it }
                )
            }
        },
        confirmButton = {
            TextButton(onClick = {
                if (cityName.isNotEmpty()) onSubmit(cityName)
                dialogState.value = false
            }) {
                Text(text = stringResource(R.string.ok))
            }
        },
        dismissButton = {
            TextButton(onClick = {
                dialogState.value = false
            }) {
                Text(text = stringResource(R.string.cancel))
            }
        },
        onDismissRequest = {
            dialogState.value = false
        },
    )
}
