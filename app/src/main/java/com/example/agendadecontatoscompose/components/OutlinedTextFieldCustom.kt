package com.example.agendadecontatoscompose.components

import Green
import Light_green
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OutlinedTextFieldCustom(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier
){
    OutlinedTextField(
        value,
        onValueChange,
        label = label,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Light_green,
            focusedBorderColor = Green
        ),
        modifier = modifier,
        maxLines = 1
    )

}