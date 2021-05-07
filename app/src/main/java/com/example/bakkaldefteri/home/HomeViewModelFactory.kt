package com.example.bakkaldefteri.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class HomeViewModelFactory(
    private val userName: String,
): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T: ViewModel?>create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(userName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}

