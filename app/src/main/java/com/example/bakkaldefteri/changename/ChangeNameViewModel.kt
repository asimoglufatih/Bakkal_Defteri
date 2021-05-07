package com.example.bakkaldefteri.changename


import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bakkaldefteri.R
import com.example.bakkaldefteri.database.User
import com.example.bakkaldefteri.database.UserDataBaseObject
import kotlinx.coroutines.launch

class ChangeNameViewModel(
    private val userDataBaseObject: UserDataBaseObject
) :ViewModel() {

    private val _userName = MutableLiveData<String?>()
    val userName: LiveData<String?>
        get() = _userName

    private val _userGender = MutableLiveData<Int>()
    val userGender: MutableLiveData<Int>
        get() = _userGender

    fun addUser(){
        viewModelScope.launch {
            var user = User()
            user.userName = userName.value.toString()
            when(userGender.value){
                R.id.ChangeNameFragmentManRadioButton -> {
                    user.userGender = " Bey"
                }
                R.id.ChangeNameFragmentWomanRadioButton -> {
                    user.userGender = " Hanım"
                }
                else -> {
                    user.userGender = " "
                }
            }
            _userName.value = _userName.value + user.userGender
            userDataBaseObject.addUser(user)
            Log.i("userData","addUser çalıştı")
            Log.i("userNameValue", userName.value.toString())
            Log.i("userGenderValue", userGender.value.toString())
            onSaved()

        }

    }

    private val _checkUserName = MutableLiveData<Boolean>()
    val checkUserName: LiveData<Boolean>
        get() = _checkUserName

    init{
        _userGender.postValue(R.id.ChangeNameFragmentDoNotWantRadioButton)
    }


    fun setUsername(s: Editable){
        _userName.value = s.toString()
    }


    private fun onSaved(){
        if(userName.value != "" || userName.value != null){
            _checkUserName.value = true
        }
    }

    fun onSavedComplete(){
        _checkUserName.value = false
    }


}

