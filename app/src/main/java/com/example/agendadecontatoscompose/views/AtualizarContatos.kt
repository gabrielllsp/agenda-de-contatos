package com.example.agendadecontatoscompose.views

import Dark_green
import Green
import WHITE
import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.agendadecontatoscompose.AppDatabase
import com.example.agendadecontatoscompose.components.ButtonCustom
import com.example.agendadecontatoscompose.components.OutlinedTextFieldCustom
import com.example.agendadecontatoscompose.dao.ContatoDao
import com.example.agendadecontatoscompose.viewmodel.ContatoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var contatoDao: ContatoDao

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun AtualizarContatos(navController: NavController, viewModel: ContatoViewModel = hiltViewModel(), uid: String) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var nome by remember {
        mutableStateOf("")
    }

    var sobreNome by remember {
        mutableStateOf("")
    }

    var idade by remember {
        mutableStateOf("")
    }
    var celular by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Dark_green,
                contentColor = WHITE,
                title = {
                    Text(text = "Atualizar Contato", fontSize = 18.sp)
                }
            )
        },

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextFieldCustom(
                value = nome,
                onValueChange = {
                    nome = it
                },
                label = {
                    Text(text = "Nome", color = Green)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, 80.dp, 20.dp, 10.dp)
            )

            OutlinedTextFieldCustom(
                value = sobreNome,
                onValueChange = {
                    sobreNome = it
                },
                label = {
                    Text(text = "Sobrenome", color = Green)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp)
            )

            OutlinedTextFieldCustom(
                value = idade,
                onValueChange = {
                    idade = it
                },
                label = {
                    Text(text = "Idade", color = Green)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp)
            )


            OutlinedTextFieldCustom(
                value = celular,
                onValueChange = {
                    celular = it
                },
                label = {
                    Text(text = "Celular", color = Green)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp)
            )

            ButtonCustom(onClick = {

                var mensagem = false

                scope.launch(Dispatchers.IO) {
                    if (nome.isEmpty() || sobreNome.isEmpty() || idade.isEmpty() || celular.isEmpty()) {
                        mensagem = false
                    } else {
                        mensagem = true
                        contatoDao = AppDatabase.getInstance(context).contatoDao()
                        contatoDao.atualizar(uid.toInt(), nome, sobreNome, idade, celular)
                    }
                }

                scope.launch(Dispatchers.Main) {
                    if (mensagem) {
                        Toast.makeText(
                            context,
                            "Usuário atualizado com sucesso",
                            Toast.LENGTH_SHORT
                        ).show()
                        navController.popBackStack()
                    } else {
                        Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT)
                            .show()
                    }

                }


            }, text = "Atualizar")
        }

    }
}

@Preview
@Composable
private fun AtualizarContatosPreview() {
    AtualizarContatos(navController = rememberNavController(), uid = "")
}