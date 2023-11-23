package com.example.agendadecontatoscompose.itemlist

import Light_green
import ShapeCardView
import WHITE
import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.agendadecontatoscompose.AppDatabase
import com.example.agendadecontatoscompose.R
import com.example.agendadecontatoscompose.dao.ContatoDao
import com.example.agendadecontatoscompose.model.Contato
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var contatoDao: ContatoDao

@Composable
fun ContatoItem(
    navController: NavController,
    position: Int,
    listaContatos: MutableList<Contato>,
    context: Context,
) {
    val scope = rememberCoroutineScope()

    val nome = listaContatos[position].nome
    val sobrenome = listaContatos[position].sobrenome
    val idade = listaContatos[position].idade
    val celular = listaContatos[position].celular
    val uid = listaContatos[position].uid
    val contato = listaContatos[position]

    fun alertDialogDeletarContato() {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Deseja Excluir?")
            .setMessage("Tem certeza?")
        alertDialog.setPositiveButton("Ok") { _, _ ->
            scope.launch(Dispatchers.IO){
                contatoDao = AppDatabase.getInstance(context).contatoDao()
                contatoDao.delete(uid)
                listaContatos.remove(contato)
            }
            scope.launch(Dispatchers.Main){
                navController.navigate("listaContatos")
                Toast.makeText(context, "Contato excluido com sucesso.", Toast.LENGTH_SHORT).show()
            }

        }
        alertDialog.setNegativeButton("Cancelar") { _, _ ->

        }
        alertDialog.show()
    }

    Card(
        backgroundColor = Light_green,
        contentColor = WHITE,
        elevation = 8.dp,
        shape = ShapeCardView.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp, 10.dp, 5.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(10.dp)
        ) {
            val (txtNome, txtSobreNome, txtIdade, txtCelular, btAtualizar, btDeletar) = createRefs()
            Text(
                text = "Contato: $nome $sobrenome",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtNome) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            Text(
                text = "Idade: $idade",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtIdade) {
                    top.linkTo(txtNome.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            Text(
                text = "Número: $celular",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtCelular) {
                    top.linkTo(txtIdade.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Button(
                onClick = {
                    navController.navigate("atualizarContatos/${uid}")

                },
                modifier = Modifier.constrainAs(btAtualizar) {

                    top.linkTo(parent.top)
                    end.linkTo(parent.end, margin = 5.dp)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Light_green
                ),
                elevation = ButtonDefaults.elevation(
                    disabledElevation = 0.dp,
                    defaultElevation = 0.dp
                )
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_edit),
                    contentDescription = "Icone de editar contato"
                )
            }
            Button(
                onClick = {
                    alertDialogDeletarContato()
                },
                modifier = Modifier.constrainAs(btDeletar) {
                    top.linkTo(btAtualizar.bottom, margin = 5.dp)
                    end.linkTo(parent.end, margin = 5.dp)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Light_green
                ),
                elevation = ButtonDefaults.elevation(
                    disabledElevation = 0.dp,
                    defaultElevation = 0.dp
                )
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_delete),
                    contentDescription = "Icone de deletar contato"
                )
            }
        }
    }

}