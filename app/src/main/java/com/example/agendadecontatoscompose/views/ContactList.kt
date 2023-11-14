package com.example.agendadecontatoscompose.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ContactList(navController: NavController) {
    Column() {
        Text(text = "Lista de Contato")
    }
}