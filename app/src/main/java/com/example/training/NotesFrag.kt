package com.example.training

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class NotesFrag : Fragment() /*,listCallback2*/{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_notes, container, false)
        retainInstance=false
        recyclerView=view.findViewById(R.id.recycler)
        emptyText=view.findViewById(R.id.emptynotesTV)
        addBtn=view.findViewById(R.id.floatingActionButton)

        val obj = Notes2DatabaseClass.getInstance(requireContext())
        loadMethod(obj)

        addBtn!!.setOnClickListener {
            startActivity(Intent(context,NotesCreateActivity3::class.java))
        }
        return view
    }

    fun loadMethod(obj:Notes2DatabaseClass){
        try {
            obj.noteDao().getAllNotes().observe(viewLifecycleOwner,object :Observer<MutableList<Notes2>>{
                override fun onChanged(t: MutableList<Notes2>?) {
                    listadapter = context?.let { NotesAdapter2(t, it) }
                    recyclerView!!.adapter = listadapter
                    NotesFrag().emptyTV_visibility()
                }
            })
        }
        catch(e:Exception){
            Log.d("tag",e.message.toString())
        }
    }

    /*inner class loadThread:Thread() {
        override fun run() {
            try {
                val obj = Notes2DatabaseClass.getInstance(context!!)
                obj.noteDao().getAllNotes().observe(this@NotesFrag,object :Observer<MutableList<Notes2>>{
                    override fun onChanged(t: MutableList<Notes2>?) {
                        listadapter = context?.let { NotesAdapter2(t, it) }
                        recyclerView!!.adapter = listadapter
                        NotesFrag().emptyTV_visibility()
                    }
                })
            }
            catch(e:Exception){
                Log.d("tag",e.message.toString())
            }

        }
    }*/


    fun emptyTV_visibility(){
        if(listadapter!!.itemCount==0) {
            emptyText!!.visibility=View.VISIBLE
        }
        else{
            emptyText!!.visibility=View.GONE
        }
    }

    companion object {
        var recyclerView:RecyclerView?=null
        var emptyText:TextView?=null
        var addBtn:FloatingActionButton?=null
        var notes:MutableList<Notes2>?=null
        var listadapter:NotesAdapter2?=null

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotesFrag().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    /*override fun update(o: Notes2) {
        notes!!.remove(o)
        notes!!.add(Notes2(o.note,o.time,0,o.id))
        listadapter!!.notifyDataSetChanged()
    }*/



}