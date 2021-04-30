package com.example.bakkaldefteri

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.btnHomeFragmenttoSpendingAddingScreenFragment.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_spendingAddingScreenFragment)
        }

        return view


    }


}
