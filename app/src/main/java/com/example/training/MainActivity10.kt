package com.example.training

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity10 : AppCompatActivity() {
    var emptyTV: TextView?=null
    var addBtn: FloatingActionButton?=null
    var recycler: RecyclerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        emptyTV = findViewById(R.id.emptynotesTV)
        recycler = findViewById(R.id.recycler)
        addBtn = findViewById(R.id.floatingActionButton)

        loadThread().start()

        addBtn!!.setOnClickListener {
            startActivity(Intent(this,NotesCreateActivity2::class.java))
        }
    }

    inner class loadThread:Thread() {
        override fun run() {
            val obj=NoteDatabaseClass.getInstance(this@MainActivity10)
            notes=obj.noteDao().getAllNotes()
            if(notes!!.isNotEmpty()){
                listadapter= NotesAdapter(notes!!,this@MainActivity10)
                recycler!!.adapter=listadapter
            }

        }
    }

    companion object {
        var notes:MutableList<Notes>?=null
        var listadapter:NotesAdapter?=null
    }
}