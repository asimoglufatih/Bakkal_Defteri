package com.example.bakkaldefteri.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities= [Spending::class], version= 1, exportSchema = false)
abstract class DataBase: RoomDatabase() {

   abstract val dataBaseObject: SpendingDataBaseObject

   companion object {

      @Volatile
      private var INSTANCE: DataBase? = null

      fun getInstance(context: Context): DataBase {
         synchronized(this) {
            var instance = INSTANCE

            if (instance == null) {
               instance = Room.databaseBuilder(
                  context.applicationContext,
                  DataBase::class.java,
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
