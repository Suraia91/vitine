package com.suraia.andela.vitrine.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class Response (
        val successo: Boolean,
        val mensagem: Any? = null,
        @SerializedName("dados")
        val dados: List<Dados>
    )
@Entity
    data class Dados (
    @PrimaryKey
        val id: String,
        val anoLectivo: AnoLectivo,
        val curso: Curso,
        val sala: String,
        val turno: String,
        val codigo: String,
        val anoCurricular: String,
        val horario: List<Horario>
    )
@Entity
    data class AnoLectivo (
    @PrimaryKey
        val id: String,
        val descricao: String,
        val abertura: String,
        val encerramento: String,
        val atual: Boolean
    )
@Entity
    data class Curso (
    @PrimaryKey
        val id: String,
        val nome: String,
        val descricao: String,
        val duracao: String,
        val codigo: String,
        val nivel: Nivel,
        val coordenador: Any? = null
    )

    enum class Nivel {
        Licenciatura,
        Mestrado,
        PósGraduação
    }
@Entity
    data class Horario (
    @PrimaryKey
        val id: String,
        val docente: Docente,
        val disciplina: Disciplina,
        val inicio: String,
        val fim: String,
        val diaSemana: DiaSemana
    )

    enum class DiaSemana {
        QuartaFeira,
        SegundaFeira,
        TerçaFeira
    }
@Entity
    data class Disciplina (
    @PrimaryKey
        val id: String,
        val nome: String,
        val codigo: String,
        val descricao: String
    )
@Entity
    data class Docente (
    @PrimaryKey
        val id: String,
        val nome: String,
        val telefone: String,
        val email: String,
        val grauAcademico: Nivel,
        val endereco: String
    )