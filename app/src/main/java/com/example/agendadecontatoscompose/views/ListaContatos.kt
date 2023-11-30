package com.example.agendadecontatoscompose.views

import Dark_green
import WHITE
import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.agendadecontatoscompose.R
import com.example.agendadecontatoscompose.itemlist.ContatoItem
import com.example.agendadecontatoscompose.viewmodel.ContatoViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun ListaContatos(navController: NavController, viewModel: ContatoViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val listaContatos = viewModel.getContatos().collectAsState(mutableListOf()).value

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

        LazyColumn {
            itemsIndexed(listaContatos) { position, _ ->
                ContatoItem(navController, position, listaContatos, context, viewModel)
            }
        }

    }
}

@Preview
@Composable
fun ContactListPreview() {
    ListaContatos(navController = rememberNavController())
}