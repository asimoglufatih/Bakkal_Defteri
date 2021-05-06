package com.example.bakkaldefteri.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bakkaldefteri.database.Spending
import com.example.bakkaldefteri.database.dataBaseObject

class HomeViewModel(
    argsUserName: String,
) : ViewModel() {

    private val _homeUserName = MutableLiveData<String>()
    val homeUserName: LiveData<String>
        get() = _homeUserName

    init{
        Log.i("homeUser",argsUserName)
        Log.i("homeUserValue",_homeUserName.value.toString())
        _homeUserName.value = argsUserName
    }

    private val spending = MutableLiveData<Spending?>()



}