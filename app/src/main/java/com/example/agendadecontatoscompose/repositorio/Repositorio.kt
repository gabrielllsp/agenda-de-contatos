package com.example.agendadecontatoscompose.repositorio

import com.example.agendadecontatoscompose.dao.ContatoDao
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repositorio @Inject constructor(private val contatoDao: ContatoDao){
}