package com.example.bakkaldefteri.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "spending_table")
data class Spending (

    @PrimaryKey(autoGenerate = true)
    val spendingId: Long = 0L,
    @ColumnInfo(name = "image_category")
    var imageCategory: String = "",
    @ColumnInfo(name = "description")
    var description: String = "",
    @ColumnInfo(name = "spendingValue")
    var spendingCost: Long = 0L,
    @ColumnInfo(name = "typeOfSpending")
    var typeOfSpending: String = "",
    @ColumnInfo(name = "typeOfMoney")
    var typeOfMoney: String = ""

)