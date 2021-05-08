package com.example.bakkaldefteri.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bakkaldefteri.database.Spending
import com.example.bakkaldefteri.database.SpendingDataBaseObject
import com.example.bakkaldefteri.database.UserDataBaseObject

class HomeViewModel(
    private val userName: UserDataBaseObject,
    private val spendingData: SpendingDataBaseObject
) : ViewModel() {

    var cost: String? = null
    val allSpending = spendingData.getAllSpending()

    private val _homeUserName = MutableLiveData<String>()
    val homeUserName: LiveData<String>
        get() = _homeUserName

    private val _toUser = MutableLiveData<Boolean?>()
    val toUser: LiveData<Boolean?>
        get() = _toUser

    private var _toAddSpending = MutableLiveData<Spending?>()
    val toAddSpending: LiveData<Spending?>
        get() = _toAddSpending

    private val _toDetails = MutableLiveData<Long?>()
    val toDetails
        get() = _toDetails

    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    fun clickAddSpending() {
        //      _toAddSpending.value = true
        _toAddSpending.value = Spending()
    }

    fun clickUser() {
        _toUser.value = true
    }

    fun clickDetail(id: Long) {
        _toDetails.value = id
    }

    fun onPlayAgain() {
        _eventPlayAgain.value = true
    }

    fun onPlayAgainComplete() {
        _eventPlayAgain.value = false
    }
}

    //private val spending = MutableLiveData<Spending?>()



