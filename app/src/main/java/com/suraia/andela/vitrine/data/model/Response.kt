package com.suraia.andela.vitrine.data.model

import com.google.gson.annotations.SerializedName


data class Response (
        val successo: Boolean,
        val mensagem: Any? = null,
        @SerializedName("Dados")
        val dados: List<Dado>
    )

    data class Dado (
        val id: String,
        val anoLectivo: AnoLectivo,
        val curso: Curso,
        val sala: String,
        val turno: String,
        val codigo: String,
        val anoCurricular: String,
        val horario: List<Horario>
    )

    data class AnoLectivo (
        val id: String,
        val descricao: String,
        val abertura: String,
        val encerramento: String,
        val atual: Boolean
    )

    data class Curso (
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

    data class Horario (
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

    data class Disciplina (
        val id: String,
        val nome: String,
        val codigo: String,
        val descricao: String
    )

    data class Docente (
        val id: String,
        val nome: String,
        val telefone: String,
        val email: String,
        val grauAcademico: Nivel,
        val endereco: String
    )