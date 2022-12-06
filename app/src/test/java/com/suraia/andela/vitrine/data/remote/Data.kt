package com.suraia.andela.vitrine.data.remote

import com.suraia.andela.vitrine.data.model.Dado
import com.suraia.andela.vitrine.data.model.LoginResponse
import com.suraia.andela.vitrine.data.model.User

 val loginResponseStub = LoginResponse(
    successo = true,
    mensagem = "Successfully logged",
    dados = Dado(
        1,
        user = User(
            id = "1",
            nome = "Test",
            identidade = "6675DFSDSV",
            157,
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            12,
            "",
            false,
            false,
            false,
            "",
            "",
            listOf(),
            listOf()
        ),
        token = "fgfddg",
        refreshToken = "hv"
    )
)