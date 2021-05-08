package com.example.bakkaldefteri.spendingadding

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bakkaldefteri.spendingadding.SpendingAddingViewModel
import com.example.bakkaldefteri.database.SpendingDataBaseObject
import java.lang.IllegalArgumentException

class SpendingAddingViewModelFactory (
    private val spendingId: Long,
    private val spendingDataBaseObject: SpendingDataBaseObject,
    ): ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T: ViewModel?>create(modelClass: Class<T>): T{
            if(modelClass.isAssignableFrom(SpendingAddingViewModel::class.java)){
                return SpendingAddingViewModel(spendingId, spendingDataBaseObject) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
