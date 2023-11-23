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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.agendadecontatoscompose.AppDatabase
import com.example.agendadecontatoscompose.R
import com.example.agendadecontatoscompose.dao.ContatoDao
import com.example.agendadecontatoscompose.itemlist.ContatoItem
import com.example.agendadecontatoscompose.model.Contato
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var contatoDao: ContatoDao

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun ListaContatos(navController: NavController) {

    val context = LocalContext.current
    val listaContatos: MutableList<Contato> = mutableListOf()
    val scope = rememberCoroutineScope()

    scope.launch(Dispatchers.IO) {
        contatoDao = AppDatabase.getInstance(context).contatoDao()
        val contatos = contatoDao.getContatos()

        for (contato in contatos) {
            listaContatos.add(contato)
        }
    }

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
            itemsIndexed(listaContatos) { position, item ->
                ContatoItem(navController, position, listaContatos, context)

            }
        }

    }
}

@Preview
@Composable
fun ContactListPreview() {
    ListaContatos(navController = rememberNavController())
}