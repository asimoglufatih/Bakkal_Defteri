package com.example.bakkaldefteri.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spending_table")
data class Spending (

    @PrimaryKey(autoGenerate = true)
    val SpendingId: Int,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "spendingValue")
    val spendingValue: Int,
    @ColumnInfo(name = "typeOfSpending")
    val typeOfSpending: Int,
    @ColumnInfo(name = "typeOfMoney")
    val typeOfMoney: Int

)