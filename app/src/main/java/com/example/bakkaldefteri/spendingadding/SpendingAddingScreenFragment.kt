package com.example.bakkaldefteri.spendingadding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.room.Database
import com.example.bakkaldefteri.R
import com.example.bakkaldefteri.database.DataBase
import com.example.bakkaldefteri.databinding.SpendingAddingScreenFragmentBinding

class SpendingAddingScreenFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: SpendingAddingScreenFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.spending_adding_screen_fragment,
                    container, false)
        val app = requireNotNull(this.activity).application
        val args = SpendingAddingScreenFragmentArgs.fromBundle(requireArguments()).key
        val spendingData = DataBase.getInstance(app).dataBaseObject

        val viewModelFactory = SpendingAddingViewModelFactory(args, spendingData)
        val spendingAddingViewModel = ViewModelProvider(
            this, viewModelFactory).get(SpendingAddingViewModel::class.java)

        binding.lifecycleOwner = this
        binding.spendingViewModel = spendingAddingViewModel

        spendingAddingViewModel.toHome.observe(viewLifecycleOwner, Observer {
            if (it==true) {
                this.findNavController()
                    .navigate(SpendingAddingScreenFragmentDirections.actionSpendingAddingScreenFragmentToHomeFragment())
            }
        })

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController()
                        .navigate(SpendingAddingScreenFragmentDirections.actionSpendingAddingScreenFragmentToHomeFragment())
                }
            }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        // Inflate the layout for this fragment
        return binding.root
    }


}