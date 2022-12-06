package com.suraia.andela.vitrine.data.remote

import com.suraia.andela.vitrine.data.model.LoginModel
import com.suraia.andela.vitrine.data.model.LoginResponse
import kotlinx.coroutines.flow.Flow

interface LoginDataSource {
    fun postLogin (auth:LoginModel):Flow<LoginResponse>
}