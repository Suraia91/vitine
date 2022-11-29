package com.suraia.andela.vitrine.data.model

import com.google.gson.annotations.SerializedName

data class Login (
    val successo: Boolean,
    val mensagem: String,
    val dados: Dados
)

data class Dados (
    @SerializedName("objecto")
    val user: User,
    val token: String,
    val refreshToken: String
)

data class User (
    val id: String,
    val nome: String,
    val identidade: String,
    val processoNumero: Long,
    val dataNascimento: String,
    val telefone: String,
    val email: String,
    val nacionalidade: String,
    val provincia: String,
    val municipio: String,
    val endereco: String,
    val estadoCivil: String,
    val nomePai: String,
    val nomeMae: String,
    val tipo: Long,
    val genero: String,
    val portadorDeficiencia: Boolean,
    val emprego: Boolean,
    val ativo: Boolean,
    val telefoneAlternativo: String,
    val provenienciaEscolar: String,
    val encarregados: List<Any?>,
    val propinas: List<Any?>
)