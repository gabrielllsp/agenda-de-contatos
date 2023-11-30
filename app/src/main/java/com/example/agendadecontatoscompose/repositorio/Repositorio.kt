package com.example.agendadecontatoscompose.repositorio

import com.example.agendadecontatoscompose.dao.ContatoDao
import com.example.agendadecontatoscompose.model.Contato
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class Repositorio @Inject constructor(private val contatoDao: ContatoDao){
    val getContatos: Flow<MutableList<Contato>> = contatoDao.getContatos()

    suspend fun salvarContato(listaContatos: MutableList<Contato>){
        contatoDao.gravar(listaContatos)
    }

    suspend fun atualizarContato(id: Int, novoNome: String, novoSobrenome: String, novaIdade: String, novoCelular: String){
        contatoDao.atualizar(id,novoNome,novoSobrenome,novaIdade,novoCelular)
    }

    suspend fun deletarContato(id: Int){
        contatoDao.deletar(id)
    }
}