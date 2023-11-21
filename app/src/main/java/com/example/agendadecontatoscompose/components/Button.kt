package com.example.agendadecontatoscompose.components

import Dark_green
import WHITE
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonCustom(
    onClick: () -> Unit, text: String
) {

    Button(
        onClick,
        colors = ButtonDefaults.buttonColors(Dark_green),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(text = text, color = WHITE, fontSize = 18.sp)

    }

}