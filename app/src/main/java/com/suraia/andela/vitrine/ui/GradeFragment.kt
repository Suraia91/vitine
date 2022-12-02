package com.suraia.andela.vitrine.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.suraia.andela.vitrine.R
import com.suraia.andela.vitrine.databinding.FragmentGradeBinding
import com.suraia.andela.vitrine.databinding.ItemGradesBinding
import com.suraia.andela.vitrine.presentation.MainViewModel
import com.suraia.andela.vitrine.ui.adapter.ListGradeAdapter
import com.suraia.andela.vitrine.ui.adapter.ListTableAdapter
import com.suraia.andela.vitrine.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GradeFragment : Fragment() {
private lateinit var binding: FragmentGradeBinding
    private val adapter by lazy { ListGradeAdapter() }
    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGradeBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        setUpAdapter()
        setUpViewModel()
        return binding.root
    }
    private fun setUpAdapter() {
        binding.rvGrades.adapter = adapter
    }
    private fun setUpViewModel() {
        viewModel.gradesResponse.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Loading->{
                    binding.progs.isVisible=it.isLoading
                }

                is NetworkResult.Error->{
                    binding.progs.isVisible = false
                    Toast.makeText(context, it.errorMessage, Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Success->{
                    binding.progs.isVisible =false
                    Toast.makeText(context, "S"+it.data.mensagem, Toast.LENGTH_SHORT).show()
                    Log.i("ver",""+it.data.dados.size)
                    adapter.submitList(it.data.dados)
                }
            }
        }
    }

}