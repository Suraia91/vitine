package com.suraia.andela.vitrine.ui

import android.content.Context
import android.content.Intent
import android.media.session.MediaSession.Token
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.suraia.andela.vitrine.data.model.LoginModel
import com.suraia.andela.vitrine.databinding.ActivityLoginBinding
import com.suraia.andela.vitrine.presentation.LoginViewModel
import com.suraia.andela.vitrine.presentation.MainViewModel
import com.suraia.andela.vitrine.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
  private lateinit var binding : ActivityLoginBinding
    private val viewModel : LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            postLogin()
        }
    }
  private fun postLogin(){
        viewModel.postLogin(loginModel = LoginModel(binding.edtLogin.text.toString(),binding.edtPwd.text.toString()))
        binding.proBar.isVisible=true
        viewModel.loginResponse.observe(this){
          when(it){
              is NetworkResult.Loading->{
                  binding.proBar.isVisible=true
              }
              is NetworkResult.Error->{
                  Toast.makeText(this, it.errorMessage, Toast.LENGTH_SHORT).show()
                  binding.proBar.isVisible=false
              }
              is NetworkResult.Success->{
                  Toast.makeText(this, it.data.mensagem, Toast.LENGTH_LONG).show()
                  binding.proBar.isVisible=false
                  saveToken("Bearer "+it.data.dados.token,it.data.dados.user.id)
                  navigateToHome()
                  Log.i("login",""+it.data.mensagem)
              }
          }
      }


  }

private fun navigateToHome(){
    val intent= Intent(this,MainActivity::class.java)
    startActivity(intent)
}
 private fun saveToken(token: String,id:String){
     val sharedPref = getSharedPreferences("Ref", MODE_PRIVATE)
     val editor =sharedPref.edit()
     editor.apply{
       putString("token",token).apply()
       putString("id",id).apply()
     }

  }
}