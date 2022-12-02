package com.suraia.andela.vitrine.presentation

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suraia.andela.vitrine.data.model.Grades
import com.suraia.andela.vitrine.data.model.Response
import com.suraia.andela.vitrine.data.repositories.Repository
import com.suraia.andela.vitrine.ui.App
import com.suraia.andela.vitrine.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val repository: Repository,
):BaseViewModel(application) {

    private var _tableResponse= MutableLiveData<NetworkResult<Response>>()
    val tableResponse: LiveData<NetworkResult<Response>> = _tableResponse

    private var _gradesResponse= MutableLiveData<NetworkResult<Grades>>()
    val gradesResponse: LiveData<NetworkResult<Grades>> = _gradesResponse
    private val shared = application.getSharedPreferences("Ref", Context.MODE_PRIVATE)

    init {
        val token = shared.getString("token",null)
        val id = shared.getString("id",null)
        getAllTimeTable(token!!,id!!)
        getAllGrades(token,id)
        Log.i("token",token)
        Log.i("id",id)

    }
    private fun getAllTimeTable(auth: String,id:String) {
        viewModelScope.launch {
            repository.getTimeTable(auth, id).collect {
            _tableResponse.postValue(it)
            }
        }
    }
    private fun getAllGrades(auth: String,id:String) {
        viewModelScope.launch {
            repository.getGrades(auth, id).collect {
                _gradesResponse.postValue(it)
            }
        }
    }


}