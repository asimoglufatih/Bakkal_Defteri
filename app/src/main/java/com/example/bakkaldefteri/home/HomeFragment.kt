package com.example.bakkaldefteri.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.bakkaldefteri.R
import com.example.bakkaldefteri.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private lateinit var viewModelFactory: HomeViewModelFactory
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.home_fragment, container, false
        )
        viewModelFactory = HomeViewModelFactory(
            HomeFragmentArgs.fromBundle(requireArguments()).argUserName)

        viewModel = ViewModelProvider(this, viewModelFactory).get(
            HomeViewModel::class.java
        )

        binding.btnHomeFragmenttoSpendingAddingScreenFragment.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_spendingAddingScreenFragment)
        }

        binding.homeFragmentUserNameTv.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_changeNameFragment)
        }

        return binding.root

    }
}


    