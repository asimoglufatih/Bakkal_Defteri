package com.example.bakkaldefteri.spendingadding

import androidx.lifecycle.*
import com.example.bakkaldefteri.R
import com.example.bakkaldefteri.database.Spending
import com.example.bakkaldefteri.database.SpendingDataBaseObject
import kotlinx.coroutines.launch


class SpendingAddingViewModel(
    private val spendingId: Long = 0L,
    private val spendingDataBaseObject:SpendingDataBaseObject,
): ViewModel() {

    var description: String? = null
    var cost: String? = null

    private val _toHome = MutableLiveData<Boolean?>()
    val toHome: LiveData<Boolean?>
        get() = _toHome

    private val _selectExpenseType = MutableLiveData<Int>()
    val selectExpenseType: MutableLiveData<Int>
        get() = _selectExpenseType

    private val _selectCurrency = MutableLiveData<Int>()
    val selectCurrency: MutableLiveData<Int>
        get() = _selectCurrency

    init {
        _selectCurrency.postValue(R.id.spendingAddingScreenFragmentTLRadioButton)
        _selectExpenseType.postValue(R.id.spendingAddingScreenFragmentOthersRadioButton)
    }

    fun onAddButtonClick() {
        viewModelScope.launch {
            val newSpending = Spending()
            newSpending.description = description.toString()
            newSpending.spendingCost = cost?.toLong()!!

            when (_selectExpenseType.value) {
                R.id.spendingAddingScreenFragmentBillRadioButton -> {
                    newSpending.typeOfSpending = "bill"
                }
                R.id.spendingAddingScreenFragmentRentRadioButton -> {
                    newSpending.typeOfSpending = "rent"
                }
                else -> newSpending.typeOfSpending = "other"
            }

            when (_selectCurrency.value) {
                R.id.spendingAddingScreenFragmentTLRadioButton -> {
                    newSpending.typeOfMoney = "TL"
                }
                R.id.spendingAddingScreenFragmentSterlingRadioButton -> {
                    newSpending.typeOfMoney = "STERLIN"
                }
                R.id.spendingAddingScreenFragmentEuroRadioButton -> {
                    newSpending.typeOfMoney = "EURO"
                }
                else -> newSpending.typeOfMoney = "DOLAR"
            }

            spendingDataBaseObject.addSpending(newSpending)

            _toHome.value = true
        }
    }

    fun clickBack(){
        _toHome.value=true
    }



}