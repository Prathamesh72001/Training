package com.example.training

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface Notes_DAO {

    @Insert
    fun insert(note:Notes)

    @Delete
    fun delete(note:Notes)

    @Update
    fun update(note:Notes)

    @Query("Select * from Notes_Table")
    fun showAllNotes():LiveData<List<Notes>>
}