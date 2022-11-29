package com.suraia.andela.vitrine.data.repositories

import com.suraia.andela.vitrine.data.services.VitrineService
import com.suraia.andela.vitrine.util.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject constructor(private val vitrineService: VitrineService){
    suspend fun getTimeTable(id:String)= flow {
        emit(NetworkResult.Loading(true))
        val response = vitrineService.getTimeTable(id)
        emit(NetworkResult.Success(response))
    }.catch { e->emit(NetworkResult.Error(e.message ?: "Ocorreu um erro, tente novamente"))
    }
}