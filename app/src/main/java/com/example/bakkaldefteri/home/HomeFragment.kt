package com.example.bakkaldefteri.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.bakkaldefteri.R
import com.example.bakkaldefteri.adapter.ClickWatcher
import com.example.bakkaldefteri.adapter.SpendingRCAdapter
import com.example.bakkaldefteri.database.DataBase
import com.example.bakkaldefteri.database.UserDataBase
import com.example.bakkaldefteri.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.home_fragment, container, false
        )
        val app = requireNotNull(this.activity).application
        val spendingData = DataBase.getInstance(app).dataBaseObject
        val userData = UserDataBase.getInstance(app).userDataBaseObject


        val viewModelFactory = HomeViewModelFactory(userData, spendingData)
        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        binding.homeFragmentViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

//        viewModel.eventPlayAgain.observe(viewLifecycleOwner, Observer { playAgain ->
//            if (playAgain) {
//                findNavController().navigate(
//                    HomeFragmentDirections.actionHomeFragmentToChangeNameFragment()
//                )
//                viewModel.onPlayAgainComplete()
//
//                }
//            }
//        )

        viewModel.toUser.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                this.findNavController()
                    .navigate(HomeFragmentDirections.actionHomeFragmentToChangeNameFragment())
            }
        })

        viewModel.toAddSpending.observe(viewLifecycleOwner, Observer { spending ->
            spending?.let {
                this.findNavController()
                    .navigate(HomeFragmentDirections.actionHomeFragmentToSpendingAddingScreenFragment(
                        spending.spendingId))
            }
        })

        val adapter = SpendingRCAdapter(ClickWatcher { spendingId ->
            viewModel.clickDetail(spendingId)
        })
        binding.homeFragmentCoordinatorLayoutRecyclerView.adapter = adapter


        binding.btnHomeFragmenttoSpendingAddingScreenFragment.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_spendingAddingScreenFragment)
        }


        viewModel.allSpending.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root

        }

    }

    