package com.suraia.andela.vitrine

import com.suraia.andela.vitrine.data.model.*
import com.suraia.andela.vitrine.data.repositories.Repository
import com.suraia.andela.vitrine.util.NetworkResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class TimeTableTestMockito {
    private val mockRepository:Repository= mock(Repository::class.java)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getTimeTableList should return timetable of specific user`()= runTest{

        val time= Horario("1",Docente("1",
            "John","2144",
            "se@gmail.com",Nivel.Licenciatura,
            "test"), Disciplina("1","Math","MT","Matematica"),
            "12:10","14:10", DiaSemana.SegundaFeira
        )
        val time1= Horario("1",Docente("1",
            "John","2144",
            "se@gmail.com",Nivel.Licenciatura,
            "test"), Disciplina("1","Math","MT","Matematica"),
            "12:10","14:10", DiaSemana.SegundaFeira
        )
        val time2= Horario("1",Docente("1",
            "John","2144",
            "se@gmail.com",Nivel.Licenciatura,
            "test"), Disciplina("1","Math","MT","Matematica"),
            "12:10","14:10", DiaSemana.SegundaFeira
        )
        val timeTableList = listOf(time,time1,time2)
        val dados = Dados("1",AnoLectivo("","","","",false),Curso("","","","","",Nivel.Mestrado),"","","","",timeTableList)
        val response: Response= Response(true,"", listOf(dados))

        `when` (mockRepository.getTimeTable("auth","id")).thenReturn(flow{response

        })

    }
}