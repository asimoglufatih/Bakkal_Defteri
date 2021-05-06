package com.example.bakkaldefteri.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities= [Spending::class], version= 1, exportSchema = false)
abstract class dataBase: RoomDatabase() {

   abstract val dataBaseObject: dataBaseObject

   companion object {

      @Volatile
      private var INSTANCE: dataBase? = null

      fun getInstance(context: Context): dataBase {
         synchronized(this) {
            var instance = INSTANCE

            if (instance == null) {
               instance = Room.databaseBuilder(
                  context.applicationContext,
                  dataBase::class.java,
                  "spending_database"
               )
                  .fallbackToDestructiveMigration()
                  .build()
               INSTANCE = instance
            }
            return instance
         }
      }
   }
}
