package com.example.training

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Notes2_DAO {
    @Insert
    fun insert(note:Notes2)

    @Query("Update Notes_Table2 set notes_col = :Note, times_col= :Time  where id = :ID")
    fun update(Note:String,Time:String,ID:Int)

    @Delete
    fun delete(note:Notes2)

    @Query("Select * from Notes_Table2")
    fun getAllNotes():LiveData<MutableList<Notes2>>

    @Query("Select * from Notes_Table2 where isfav_col = 1")
    fun getFavNotes():LiveData<MutableList<Notes2>>

    @Query("Update Notes_Table2 set isfav_col=1 where id=:ID")
    fun setFav(ID:Int)

    @Query("Update Notes_Table2 set isfav_col=0 where id=:ID")
    fun setUnfav(ID:Int)
}