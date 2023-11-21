package com.example.agendadecontatoscompose.views

import Dark_green
import WHITE
import android.annotation.SuppressLint
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.agendadecontatoscompose.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListaContatos(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Dark_green,
                contentColor = WHITE,
                title = {
                    Text(text = "Agenda de Contatos", fontSize = 18.sp)
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                          navController.navigate("salvarContatos")
                },
                backgroundColor = Dark_green,
                contentColor = WHITE
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Icone de adicionar novo contato",
                )
            }
        }
    ) {

    }
}

@Preview
@Composable
fun ContactListPreview() {
    ListaContatos(navController = rememberNavController())
}