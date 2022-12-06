package com.suraia.andela.vitrine.data.remote

import com.suraia.andela.vitrine.data.model.LoginModel
import com.suraia.andela.vitrine.data.services.VitrineService
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertTrue



class LoginDataSourceImplTest {

    private val vitrineServiceMockk = mockk<VitrineService>(
        relaxed = true
    )

    private val loginDataSourceImpl = LoginDataSourceImpl(
        vitrineService = vitrineServiceMockk
    )

    @Test
    fun `when loginDataSource return successfully data`() = runBlocking {
        //Given
        val loginStub = loginResponseStub
        every {
            loginDataSourceImpl.postLogin(
                auth = LoginModel(
                    login = "92113232",
                    senha = "1234"
                )
            )
        } returns flow { emit(loginStub) }

        //Verify
        assertEquals(loginStub, loginResponseStub)
    }
}