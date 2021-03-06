package com.example.bakkaldefteri.changename

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bakkaldefteri.database.UserDataBaseObject
import com.example.bakkaldefteri.home.HomeViewModel
import java.lang.IllegalArgumentException

class ChangeNameViewModelFactory(
    private val userDataBaseObject: UserDataBaseObject
): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel?>create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(ChangeNameViewModel::class.java)){
            return ChangeNameViewModel(userDataBaseObject) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}