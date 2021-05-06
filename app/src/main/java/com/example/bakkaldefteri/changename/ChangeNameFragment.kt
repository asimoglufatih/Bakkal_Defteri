package com.example.bakkaldefteri.changename

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BaseObservable
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.bakkaldefteri.R
import com.example.bakkaldefteri.databinding.ChangeNameFragmentBinding

class ChangeNameFragment : Fragment() {

    private lateinit var binding: ChangeNameFragmentBinding
    private lateinit var viewModel: ChangeNameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.change_name_fragment, container, false)

        val viewModelFactory = ChangeNameViewModelFactory()
        viewModel = ViewModelProvider(
                this, viewModelFactory).get(ChangeNameViewModel::class.java)

        binding.changeNameViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val userName = binding.ChangeNameFragmentEditTextDescription.text.toString()

        viewModel.checkUserName.observe(viewLifecycleOwner, Observer<Boolean>{ newCheckUserName ->
            if(newCheckUserName){
                val action = ChangeNameFragmentDirections.actionChangeNameFragmentToHomeFragment(
                    userName)
                NavHostFragment.findNavController(this).navigate(action)
                viewModel.onSavedComplete()
            }

        })


        return binding.root
    }





}