package com.example.agendadecontatoscompose

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.agendadecontatoscompose.dao.ContatoDao
import com.example.agendadecontatoscompose.model.Contato

@Database(entities = [Contato::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun contatoDao(): ContatoDao

}