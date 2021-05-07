package com.example.bakkaldefteri.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var UserId: Long = 0L,
    @ColumnInfo(name = "userName")
    var userName: String = "",
    @ColumnInfo(name = "gender")
    var userGender: String = ""
)
