package com.suraia.andela.vitrine

import android.app.Application
import com.suraia.andela.vitrine.data.repositories.Repository
import com.suraia.andela.vitrine.presentation.MainViewModel
import org.junit.Before
import org.mockito.Mockito.mock

class MainViewModelTest {
    private val repo = Repository()
    private val app= mock<Application>()
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup(){
        viewModel= MainViewModel(,repo)
    }
}