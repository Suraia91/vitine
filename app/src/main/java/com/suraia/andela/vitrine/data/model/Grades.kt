package com.suraia.andela.vitrine.data.model

import com.google.gson.annotations.SerializedName

data class Grades (
    val successo: Boolean,
    val mensagem: String ? = null,
    @SerializedName("Dados")
    val dados: List<Dads>
)
data class Dads (
    val turma: Turma,
    val notas: List<Nota>
)

data class Nota (
    val id: String,
    val disciplina: Disciplina,
    val primeiraFrequencia: Long? = null,
    val segundaFrequencia: Any? = null,
    val recurso: Any? = null,
    val exame: Long? = null,
    val exameEspecial: Any? = null,
    val apto: Boolean
)


data class Turma (
    val id: String,
    val anoLectivo: AnoLectivo,
    val curso: Curso,
    val sala: String,
    val turno: String,
    val codigo: String,
    val anoCurricular: String
)
