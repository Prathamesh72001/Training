package com.example.training

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.training.Notes_DAO

class NotesCreateActivity2 : AppCompatActivity(){
    var editText:EditText?=null
    var backBtn: ImageView?=null
    var saveBtn: FloatingActionButton?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_create2)

        editText=findViewById(R.id.editText)
        backBtn=findViewById(R.id.backBtn)
        saveBtn=findViewById(R.id.floatingActionButton)

        saveBtn!!.setOnClickListener {
            insertbgThread().start()
        }

        backBtn!!.setOnClickListener {
            startActivity(Intent(this,MainActivity9::class.java))
            finish()
        }
    }

    inner class insertbgThread:Thread(){
        override fun run(){
            super.run()
            val obj=NoteDatabaseClass.getInstance(this@NotesCreateActivity2)
            obj.noteDao().insert(Notes(editText!!.text.toString()))
            Toast.makeText(this@NotesCreateActivity2,"Note Inserted Successfully", Toast.LENGTH_LONG).show()
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this,MainActivity9::class.java))
        finish()
        super.onBackPressed()
    }

}