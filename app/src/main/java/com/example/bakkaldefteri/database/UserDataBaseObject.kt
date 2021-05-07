package com.example.bakkaldefteri.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDataBaseObject {
    @Insert
    suspend fun addUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY UserId DESC LIMIT 1")
    suspend fun getUser():User
}