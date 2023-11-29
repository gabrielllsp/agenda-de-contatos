package com.example.agendadecontatoscompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.agendadecontatoscompose.repositorio.Repositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContatoViewModel @Inject constructor(private val repositorio: Repositorio): ViewModel(){
}