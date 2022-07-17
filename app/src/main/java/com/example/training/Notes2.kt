package com.example.training

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_Table2")
data class Notes2(@ColumnInfo(name = "notes_col")val note:String,
                  @ColumnInfo(name = "times_col")val time:String,
                  @ColumnInfo(name = "isfav_col")val isfav:Int,
                  @PrimaryKey(autoGenerate =true)val id:Int?=null)
{

}