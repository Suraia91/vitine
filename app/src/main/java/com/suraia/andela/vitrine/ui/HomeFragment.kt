package com.suraia.andela.vitrine.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.suraia.andela.vitrine.R
import com.suraia.andela.vitrine.databinding.FragmentHomeBinding
import com.suraia.andela.vitrine.databinding.FragmentMainBinding


class HomeFragment : Fragment() {

lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val navHostFragment = childFragmentManager.findFragmentById(binding.root.id) as NavHostFragment

        binding.btnNavigationView.setupWithNavController(navController = navHostFragment.navController)

        return binding.root
    }

}