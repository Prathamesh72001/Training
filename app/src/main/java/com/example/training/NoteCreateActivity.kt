package com.example.training

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.core.widget.addTextChangedListener
import com.google.android.material.floatingactionbutton.FloatingActionButton


class NoteCreateActivity : AppCompatActivity() {
    val SHARED_PREF = "sharedPref"
    val KEY_SET = "notes"
    var editText:EditText?=null
    var backBtn:ImageView?=null
    var saveBtn:FloatingActionButton?=null
    var noteID:Int?=null
    var sharedPreferences:SharedPreferences?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_create)

        sharedPreferences=this.getSharedPreferences(SHARED_PREF, MODE_PRIVATE)
        editText=findViewById(R.id.editText)
        backBtn=findViewById(R.id.backBtn)
        saveBtn=findViewById(R.id.floatingActionButton)
        noteID=intent.getIntExtra("noteID",-1)

        if(noteID!=-1){
            editText!!.text=Editable.Factory.getInstance().newEditable(MainActivity9.notes[noteID!!])
        }


        saveBtn!!.setOnClickListener {
            if(noteID!=-1) {
                MainActivity9.notes.set(
                    noteID!!,
                    editText!!.text.toString()
                )
                MainActivity9().listadapter?.notifyDataSetChanged()
                val notesSet = HashSet<String>(MainActivity9.notes)
                sharedPreferences!!.edit().putStringSet(KEY_SET, notesSet).apply()
                startActivity(Intent(this, MainActivity9::class.java))
                finish()
            }
            else{
                if(MainActivity9.notes==null){
                    var n= MainActivity9.notes
                    n?.add(
                        editText!!.text.toString()
                    )
                    MainActivity9().listadapter?.notifyDataSetChanged()
                    val notesSet = HashSet<String>(n)
                    sharedPreferences!!.edit().putStringSet(KEY_SET, notesSet).apply()
                    startActivity(Intent(this, MainActivity9::class.java))
                    finish()
                }
                else{
                    MainActivity9.notes!!.add(
                        editText!!.text.toString()
                    )
                    MainActivity9().listadapter?.notifyDataSetChanged()
                    val notesSet = HashSet<String>(MainActivity9.notes)
                    sharedPreferences!!.edit().putStringSet(KEY_SET, notesSet).apply()
                    startActivity(Intent(this, MainActivity9::class.java))
                    finish()
                }
            }
        }

        backBtn!!.setOnClickListener {
            startActivity(Intent(this,MainActivity9::class.java))
            finish()
        }

    }


    override fun onBackPressed() {
        startActivity(Intent(this,MainActivity9::class.java))
        finish()
        super.onBackPressed()
    }
}