package com.example.agendadecontatoscompose

import AgendaDeContatosComposeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.agendadecontatoscompose.views.AtualizarContatos
import com.example.agendadecontatoscompose.views.ListaContatos
import com.example.agendadecontatoscompose.views.SalvarContatos


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgendaDeContatosComposeTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "listaContatos"
                ) {
                    composable("listaContatos") {
                        ListaContatos(navController)
                    }
                    composable("salvarContatos") {
                        SalvarContatos(navController)
                    }
                    composable(
                        "atualizarContatos/{uid}",
                        arguments = listOf(navArgument("uid") {})
                    ) {
                        AtualizarContatos(navController, it.arguments?.getString("uid").toString())
                    }
                }

            }
        }
    }

}