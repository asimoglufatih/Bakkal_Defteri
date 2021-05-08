package com.example.bakkaldefteri.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bakkaldefteri.database.SpendingDataBaseObject
import com.example.bakkaldefteri.database.UserDataBase
import com.example.bakkaldefteri.database.UserDataBaseObject
import java.lang.IllegalArgumentException

class HomeViewModelFactory(
    private val userName: UserDataBaseObject,
    private val spendingData: SpendingDataBaseObject
): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T: ViewModel?>create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(userName, spendingData) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}

