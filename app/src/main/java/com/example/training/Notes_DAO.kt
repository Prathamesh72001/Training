package com.example.training

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface Notes_DAO {

    @Insert
    fun insert(note:Notes)

    @Query("Update Notes_Table set Notes_Col = :Note where id = :ID")
    fun update(Note:String,ID:Int)

    @Delete
    fun delete(note:Notes)

    @Query("Select * from Notes_Table")
    fun getAllNotes():MutableList<Notes>
}