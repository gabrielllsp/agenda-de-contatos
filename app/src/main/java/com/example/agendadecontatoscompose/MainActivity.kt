package com.example.agendadecontatoscompose

import AgendaDeContatosComposeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.agendadecontatoscompose.viewmodel.ContatoViewModel
import com.example.agendadecontatoscompose.views.AtualizarContatos
import com.example.agendadecontatoscompose.views.ListaContatos
import com.example.agendadecontatoscompose.views.SalvarContatos
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgendaDeContatosComposeTheme {

                val navController = rememberNavController()
                val viewModel: ContatoViewModel = hiltViewModel()

                NavHost(
                    navController = navController,
                    startDestination = "listaContatos"
                ) {
                    composable("listaContatos") {
                        ListaContatos(navController,viewModel)
                    }
                    composable("salvarContatos") {
                        SalvarContatos(navController, viewModel)
                    }
                    composable(
                        "atualizarContatos/{uid}",
                        arguments = listOf(navArgument("uid") {})
                    ) {
                        AtualizarContatos(navController, viewModel,it.arguments?.getString("uid").toString())
                    }
                }

            }
        }
    }

}