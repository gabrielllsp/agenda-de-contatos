package com.example.agendadecontatoscompose.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.agendadecontatoscompose.model.Contato
import kotlinx.coroutines.flow.Flow

@Dao
interface ContatoDao {

    @Insert
    suspend fun gravar(listaContatos: MutableList<Contato>)

    @Query("SELECT * FROM tabela_contatos ORDER BY nome ASC")
    fun getContatos(): Flow<MutableList<Contato>>

    @Query("UPDATE tabela_contatos SET nome = :novoNome, sobrenome = :novoSobrenome, idade = :novaIdade, celular = :novoCelular " +
            "WHERE uid = :id")
    suspend fun atualizar(id: Int, novoNome: String, novoSobrenome: String, novaIdade: String, novoCelular: String)

    @Query("DELETE FROM tabela_contatos WHERE uid = :id")
    suspend fun deletar(id: Int)
}