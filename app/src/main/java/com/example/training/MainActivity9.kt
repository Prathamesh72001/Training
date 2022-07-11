package com.example.training

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.nfc.cardemulation.CardEmulation
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.Adapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet as HashSet1

class MainActivity9 : AppCompatActivity() {
    val SHARED_PREF = "sharedPref"
    val KEY_SET = "notes"
    var emptyTV:TextView?=null
    var addBtn:FloatingActionButton?=null
    var listView:ListView?=null
    var listadapter:ArrayAdapter<String>?=null
    var sharedPreferences:SharedPreferences?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

        emptyTV = findViewById(R.id.emptynotesTV)
        listView = findViewById(R.id.listview)
        addBtn = findViewById(R.id.floatingActionButton)


         sharedPreferences=this.getSharedPreferences(SHARED_PREF, MODE_PRIVATE)

        val notesSet= sharedPreferences!!.getStringSet(KEY_SET,null)
        if(notesSet==null)
        {
            emptyTV!!.visibility=View.VISIBLE
        }
        else{
            emptyTV!!.visibility=View.GONE
            Companion.notes = ArrayList(notesSet)
        }


        listadapter= ArrayAdapter(this,R.layout.notes_layout,R.id.note, notes)
        listView!!.adapter=listadapter

        listView!!.setOnItemClickListener { parent, view, position, id ->
            val intent= Intent(this,NoteCreateActivity::class.java)
            intent.putExtra("noteID",id.toInt())
            startActivity(intent)
        }

        listView!!.setOnItemLongClickListener { parent, view, position, id ->
            AlertDialog.Builder(this).setTitle("Delete Note").setMessage("Do you want to delete this note ?")
                .setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                    Companion.notes!!.removeAt(position)
                    listadapter!!.notifyDataSetChanged()
                    val notesSet= HashSet1<String>(Companion.notes)
                    sharedPreferences!!.edit().putStringSet(KEY_SET,notesSet).apply()

                    if(notesSet.isEmpty()){
                        emptyTV!!.visibility=View.VISIBLE
                    }

                }).setNegativeButton("No",null).show()
            return@setOnItemLongClickListener true
        }

        addBtn!!.setOnClickListener {
            val intent=Intent(this,NoteCreateActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        var notes=   ArrayList<String>()
    }


}