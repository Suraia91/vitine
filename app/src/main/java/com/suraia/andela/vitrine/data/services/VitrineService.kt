package com.suraia.andela.vitrine.data.services

import com.suraia.andela.vitrine.data.model.*
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface VitrineService {

    @GET("Alunos/{id}/horarios")
    suspend fun getTimeTable(@Header("Authorization")authorization: String,@Path("id") id: String):Response
    @GET("Alunos/{id}/notas")
    suspend fun getGrades(@Header("Authorization") authorization: String,@Path("id") id: String):Grades

    @POST("Alunos/login")
    suspend fun postLogin(@Body loginModel: LoginModel):LoginResponse

}