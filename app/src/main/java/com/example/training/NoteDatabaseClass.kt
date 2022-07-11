package com.example.training

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [Notes::class],version = 1)
abstract class NoteDatabaseClass : RoomDatabase() {
    abstract fun noteDao(): Notes_DAO

    companion object {
        private var instance: NoteDatabaseClass? = null

        @Synchronized
        fun getInstance(context: Context): NoteDatabaseClass {
            if (instance == null) {
                instance = Room.databaseBuilder(context, NoteDatabaseClass::class.java, "mydb").build()
            }

            return instance!!

        }
    }
}