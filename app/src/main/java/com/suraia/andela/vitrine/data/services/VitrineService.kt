package com.suraia.andela.vitrine.data.services

import com.suraia.andela.vitrine.data.model.Grades
import com.suraia.andela.vitrine.data.model.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface VitrineService {

    @GET("Alunos/{id}/horarios")
    suspend fun getTimeTable(@Header("Authorization")authorization: String,@Path("id") id: String):List<Response>
    @GET("Alunos/{id}/notas")
    suspend fun getGrades(@Header("Authorization")authorization: String,@Path("id") id: String):List<Grades>

    @POST("Alunos/login")
    suspend fun PostLogin(@Body data:Map<String,String>)

}