package com.suraia.andela.vitrine.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suraia.andela.vitrine.data.model.Grades
import com.suraia.andela.vitrine.data.model.Login
import com.suraia.andela.vitrine.data.model.LoginModel
import com.suraia.andela.vitrine.data.model.Response
import com.suraia.andela.vitrine.data.repositories.Repository
import com.suraia.andela.vitrine.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {

    private var _loginResponse= MutableLiveData<NetworkResult<Login>>()
    val loginResponse: LiveData<NetworkResult<Login>> = _loginResponse

     fun postLogin(loginModel: LoginModel) {
        // _loginResponse.postValue(NetworkResult.Loading(true))
          viewModelScope.launch {
            repository.postLogin(loginModel).collect {
            _loginResponse.postValue(it)
            }
        }
    }
}