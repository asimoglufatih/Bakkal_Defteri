package com.example.bakkaldefteri.spendingadding

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bakkaldefteri.database.SpendingDataBaseObject
import java.lang.Exception
import java.util.*


class SpendingAddingViewModel(
    spendingDataBaseObject:SpendingDataBaseObject,
    app:Application
): ViewModel() {

    //private val context = getApplication<Application>().applicationContext
    private val spendingDataBase = spendingDataBaseObject
    private val _navigateToHome = MutableLiveData<Boolean>()
    val navigateToHome: LiveData<Boolean>
        get() = _navigateToHome

    fun createSpending(description:String, txtCost:String, typeOfSpending: Int, currencyType: Int ){

        try {
            if(typeOfSpending != -1 && description != "" && txtCost != ""){


            }
            else{
                //Toast.makeText(ViewModel, "Tüm alanları doldurmalısınız", Toast. LENGTH_LONG);
            }

        }
        catch (ex:Exception){
            Log.e("ERROR", "SpendingAddingViewModel.createSpending() is don't work")
        }

    }

}