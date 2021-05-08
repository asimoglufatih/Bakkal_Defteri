package com.example.bakkaldefteri.spendingadding

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bakkaldefteri.spendingadding.SpendingAddingViewModel
import com.example.bakkaldefteri.database.SpendingDataBaseObject
import java.lang.IllegalArgumentException

class SpendingAddingViewModelFactory (
    private val spendingDataBaseObject: SpendingDataBaseObject,
    private val app: Application
    ): ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T: ViewModel?>create(modelClass: Class<T>): T{
            if(modelClass.isAssignableFrom(SpendingAddingViewModel::class.java)){
                return SpendingAddingViewModel(spendingDataBaseObject, app) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
