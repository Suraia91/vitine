package com.suraia.andela.vitrine.data.model

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("login")
    val login: String,
    @SerializedName("senha")
    val senha: String,
)
