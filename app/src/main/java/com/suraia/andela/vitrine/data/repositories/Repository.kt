package com.suraia.andela.vitrine.data.repositories

import com.suraia.andela.vitrine.data.model.LoginModel
import com.suraia.andela.vitrine.data.services.VitrineService
import com.suraia.andela.vitrine.util.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject constructor(private val vitrineService: VitrineService){

    suspend fun getTimeTable(auth: String,id:String)= flow {
        emit(NetworkResult.Loading(true))
        val responseTime = vitrineService.getTimeTable(auth,id)
        emit(NetworkResult.Success(responseTime))
    }.catch { e->emit(NetworkResult.Error(e.message ?: "Ocorreu um erro, tente novamente"))
    }

    suspend fun getGrades(auth: String,id:String)= flow {
        emit(NetworkResult.Loading(true))
        val responseGrades = vitrineService.getGrades(auth,id)
        emit(NetworkResult.Success(responseGrades))
    }.catch { e->emit(NetworkResult.Error(e.message ?: "Ocorreu um erro, tente novamente"))
    }
    suspend fun postLogin(loginModel: LoginModel)= flow {
        emit(NetworkResult.Loading(false))
        val responseLogin = vitrineService.postLogin(loginModel)
        emit(NetworkResult.Success(responseLogin))
    }.catch { e->emit(NetworkResult.Error(e.message ?: "Ocorreu um erro, tente novamente"))
    }


}