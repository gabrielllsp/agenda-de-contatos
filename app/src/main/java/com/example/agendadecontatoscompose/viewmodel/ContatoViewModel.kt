package com.example.agendadecontatoscompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendadecontatoscompose.model.Contato
import com.example.agendadecontatoscompose.repositorio.Repositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContatoViewModel @Inject constructor(private val repositorio: Repositorio): ViewModel(){
    private val _todosContatos = MutableStateFlow<MutableList<Contato>>(mutableListOf())
    private val todosContatos: StateFlow<MutableList<Contato>> = _todosContatos

    fun salvarContato(listaContatos: MutableList<Contato>){
        viewModelScope.launch {
            repositorio.salvarContato(listaContatos)
        }
    }

    fun getContatos(): Flow<MutableList<Contato>> {
        viewModelScope.launch {
            repositorio.getContatos.collect{
                _todosContatos.value = it
            }
        }
        return todosContatos
    }

    fun atualizarContato(id: Int, novoNome: String, novoSobrenome: String, novaIdade: String, novoCelular: String){
        viewModelScope.launch {
            repositorio.atualizarContato(id,novoNome,novoSobrenome,novaIdade,novoCelular)
        }
    }

    fun deletarContato(id: Int){
        viewModelScope.launch {
            repositorio.deletarContato(id)
        }
    }
}