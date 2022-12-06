package com.suraia.andela.vitrine.data.remote

import com.suraia.andela.vitrine.data.model.LoginModel
import com.suraia.andela.vitrine.data.model.LoginResponse
import com.suraia.andela.vitrine.data.services.VitrineService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class LoginDataSourceImpl @Inject constructor(
    private val vitrineService: VitrineService
) : LoginDataSource {

    override fun postLogin(auth: LoginModel): Flow<LoginResponse> {
        return flow {
            emit(vitrineService.postLogin(loginModel = auth))
        }
    }
}