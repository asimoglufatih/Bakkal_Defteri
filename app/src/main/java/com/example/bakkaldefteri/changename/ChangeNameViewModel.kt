package com.example.bakkaldefteri.changename

import android.app.Application
import android.text.Editable
import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChangeNameViewModel() :ViewModel() {

    private val _userName = MutableLiveData<String?>()
    val userName: LiveData<String?>
        get() = _userName


    private val _userGender = MutableLiveData<Int>()
    val userGender: LiveData<Int>
        get() = _userGender

    private val _checkUserName = MutableLiveData<Boolean>()
    val checkUserName: LiveData<Boolean>
        get() = _checkUserName

    init{

    }

    fun setUsername(s: Editable){
        Log.i("userName", s.toString())
        Log.i("userNameValue", userName.value.toString())
        _userName.value = s.toString()
    }

    fun onSaved(){
        if(userName.value != "" || userName.value != null){
            _checkUserName.value = true
        }

    }

    fun onSavedComplete(){
        _checkUserName.value = false
    }


}

