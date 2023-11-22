package com.example.agendadecontatoscompose.itemlist

import Light_green
import ShapeCardView
import WHITE
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.agendadecontatoscompose.R
import com.example.agendadecontatoscompose.model.Contato

@Composable
fun ContatoItem(
    navController: NavController,
    position: Int,
    listaContatos: MutableList<Contato>,
    context: Context,
) {

    val nome = listaContatos[position].nome
    val sobrenome = listaContatos[position].sobrenome
    val idade = listaContatos[position].idade
    val celular = listaContatos[position].celular

    Card(
        backgroundColor = Light_green,
        contentColor = WHITE,
        elevation = 8.dp,
        shape = ShapeCardView.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 20.dp, 10.dp, 10.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (txtNome, txtSobreNome, txtIdade, txtCelular, btAtualizar, btDeletar) = createRefs()
            Text(
                text = "Contato: $nome $sobrenome",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtNome) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            Text(
                text = "Idade: $idade",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtIdade) {
                    top.linkTo(txtNome.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            Text(
                text = "Número: $celular",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtCelular) {
                    top.linkTo(txtIdade.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Button(
                onClick = {
                          navController.navigate("atualizarContatos")

                },
                modifier = Modifier.constrainAs(btAtualizar) {
                    start.linkTo(txtCelular.end, margin = 30.dp)
                    top.linkTo(parent.top, margin = 50.dp)
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

                },
                modifier = Modifier.constrainAs(btDeletar) {
                    start.linkTo(btAtualizar.end, margin = 10.dp)
                    top.linkTo(parent.top, margin = 50.dp)
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