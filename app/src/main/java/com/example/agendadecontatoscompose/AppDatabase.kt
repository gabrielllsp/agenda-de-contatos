package com.example.agendadecontatoscompose

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.agendadecontatoscompose.constant.Constantes
import com.example.agendadecontatoscompose.model.Contato

@Database(entities = [Contato::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    companion object{

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    Constantes.DB_CONTATOS
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}