package com.suraia.andela.vitrine.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.suraia.andela.vitrine.databinding.FragmentMainBinding
import com.suraia.andela.vitrine.presentation.MainViewModel
import com.suraia.andela.vitrine.ui.adapter.ListTableAdapter
import com.suraia.andela.vitrine.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    //private val dialog by lazy { createProgressDialog() }
    private val adapter by lazy { ListTableAdapter() }
    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        //val navHostFragment = childFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

        //binding.btnNavigationView.setupWithNavController(navHostFragment.navController)
         setUpAdapter()
         setUpViewModel()
         return binding.root
    }


    private fun setUpAdapter() {
        binding.rvTable.adapter = adapter
    }
    private fun setUpViewModel() {
        viewModel.tableResponse.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Loading->{
                    binding.prog.isVisible=it.isLoading
                }

                is NetworkResult.Error->{
                    binding.prog.isVisible = false
                    Toast.makeText(context, it.errorMessage, Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Success->{
                    binding.prog.isVisible =false
                    Toast.makeText(context, "S"+it.data.mensagem, Toast.LENGTH_SHORT).show()

                    adapter.submitList(it.data.dados)
                }
            }
        }
    }

    }