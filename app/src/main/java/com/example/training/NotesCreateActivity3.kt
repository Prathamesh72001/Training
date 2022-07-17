package com.example.training

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NotesCreateActivity3 : AppCompatActivity() {
    var editText: EditText? = null
    var backBtn: ImageView? = null
    var saveBtn: FloatingActionButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_create3)

        editText = findViewById(R.id.editText)
        backBtn = findViewById(R.id.backBtn)
        saveBtn = findViewById(R.id.floatingActionButton)

        noteID = intent.getIntExtra("dataid", -1)
        note = intent.getStringExtra("datanote")

        if (noteID != -1) {
            editText!!.text= Editable.Factory.getInstance().newEditable(note)
        }


        saveBtn!!.setOnClickListener {
            if (noteID == -1) {
                val note = editText!!.text.toString()
                if (inputCheck(note)) {
                    insertThread().start()
                    Toast.makeText(this, "Note Inserted Successfully", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, MainActivity11::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Please Write Note", Toast.LENGTH_LONG).show()
                }
            } else if(noteID !=-1){
                val note = editText!!.text.toString()
                if (inputCheck(note)) {
                    updateThread().start()
                    Toast.makeText(this, "Note Updated Successfully", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, MainActivity11::class.java))
                    finish()
                }
            }
        }

        backBtn!!.setOnClickListener {
            startActivity(Intent(this, MainActivity11::class.java))
            finish()
        }
    }

    inner class insertThread : Thread() {
        @RequiresApi(Build.VERSION_CODES.O)
        override fun run() {
            val dtf:DateTimeFormatter= DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")
            val obj=Notes2DatabaseClass.getInstance(this@NotesCreateActivity3)
            obj.noteDao().insert(Notes2(editText!!.text.toString(),dtf.format(LocalDateTime.now()),0))
        }
    }

    inner class updateThread():Thread(){
        @RequiresApi(Build.VERSION_CODES.O)
        override fun run() {
            val dtf:DateTimeFormatter= DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")
            val obj=Notes2DatabaseClass.getInstance(this@NotesCreateActivity3)
            obj.noteDao().update(editText!!.text.toString(),dtf.format(LocalDateTime.now()) ,noteID!!)
        }
    }

    fun inputCheck(note: String): Boolean {
        return !TextUtils.isEmpty(note)
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity11::class.java))
        finish()
        super.onBackPressed()
    }

    companion object{
        var noteID: Int? = null
        var note: String? = null
    }
}