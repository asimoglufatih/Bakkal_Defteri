package com.example.bakkaldefteri.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface dataBaseObject {

    @Insert
    fun add(spending: Spending)

    @Query("SELECT * FROM spending_table ORDER BY description" )
    fun getAllSpending(): LiveData<List<Spending>>

    @Delete
    fun delete(spending: Spending)




}