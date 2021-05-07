package com.example.bakkaldefteri.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(
    private val userName: String,
) : ViewModel() {

    private val _homeUserName = MutableLiveData<String>()
    val homeUserName: LiveData<String>
        get() = _homeUserName

    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    fun onPlayAgain(){
        _eventPlayAgain.value = true
    }

    fun onPlayAgainComplete(){
        _eventPlayAgain.value = false
    }

    init{
        _homeUserName.value = userName
        Log.i("homeUser",userName)
        Log.i("homeUserValue",_homeUserName.value.toString())

    }

    //private val spending = MutableLiveData<Spending?>()



}