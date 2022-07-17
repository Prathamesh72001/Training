package com.example.training

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notes2::class],version = 2)
abstract class Notes2DatabaseClass : RoomDatabase(){
    abstract fun noteDao(): Notes2_DAO

    companion object {
        private var instance: Notes2DatabaseClass? = null

        @Synchronized
        fun getInstance(context: Context): Notes2DatabaseClass {
            if(instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,Notes2DatabaseClass::class.java,"mydb").fallbackToDestructiveMigration().build()
            }

            return instance!!

        }
    }
}