package com.example.agendadecontatoscompose

import AgendaDeContatosComposeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.agendadecontatoscompose.views.ContactList
import com.example.agendadecontatoscompose.views.SaveContacts
import com.example.agendadecontatoscompose.views.UpdateContacts


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgendaDeContatosComposeTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "contactList"){
                    composable("contactList"){
                        ContactList(navController)
                    }
                    composable("saveContacts"){
                        SaveContacts(navController)
                    }
                    composable("updateContacts"){
                        UpdateContacts(navController)
                    }
                }

            }
        }
    }

}