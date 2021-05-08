package com.example.bakkaldefteri.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SpendingDataBaseObject {

    @Insert
    fun addSpending(spending: Spending)

    @Query("SELECT * FROM spending_table ORDER BY description" )
    fun getAllSpending(): LiveData<List<Spending>>

    @Query("SELECT * FROM spending_table WHERE spendingId= :idNo")
    suspend fun read(idNo: Long): Spending?

    @Query("SELECT * FROM spending_table ORDER BY spendingId DESC LIMIT 1")
    suspend fun readLast(): Spending?

    @Delete
    suspend fun deleteSpending(spending: Spending)







}