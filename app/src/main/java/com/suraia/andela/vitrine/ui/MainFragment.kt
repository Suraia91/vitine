package com.suraia.andela.vitrine.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.suraia.andela.vitrine.R
import com.suraia.andela.vitrine.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        //val navHostFragment = childFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

        //binding.btnNavigationView.setupWithNavController(navHostFragment.navController)

        return binding.root
    }

}