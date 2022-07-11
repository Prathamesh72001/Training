package com.example.training

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_Table")
data class Notes(@ColumnInfo(name = "Notes_Col")val note:String, @PrimaryKey(autoGenerate =true) val id:Int?=null) {
}