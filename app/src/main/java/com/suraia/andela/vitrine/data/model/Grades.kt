package com.suraia.andela.vitrine.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Grades (
    val successo: Boolean,
    val mensagem: String ? = null,
    @SerializedName("dados")
    val dados: List<Dads>
)
@Entity
data class Dads (
    @PrimaryKey(autoGenerate = true)
    val Id:Int,
    val turma: Turma,
    val notas: List<Nota>
)
@Entity
data class Nota (
    @PrimaryKey
    val id: String,
    val disciplina: Disciplina,
    val primeiraFrequencia: Long? = null,
    val segundaFrequencia: Any? = null,
    val recurso: Any? = null,
    val exame: Long? = null,
    val exameEspecial: Any? = null,
    val apto: Boolean
)

@Entity
data class Turma (
    @PrimaryKey
    val id: String,
    val anoLectivo: AnoLectivo,
    val curso: Curso,
    val sala: String,
    val turno: String,
    val codigo: String,
    val anoCurricular: String
)
