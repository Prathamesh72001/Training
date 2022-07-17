package com.example.training

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FavouriteFrag : Fragment(){
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
        retainInstance=false
        view1=inflater.inflate(R.layout.fragment_favourite, container, false)
        recyclerView =view1!!.findViewById(R.id.recycler)
        emptyText =view1!!.findViewById(R.id.emptynotesTV)
        addBtn =view1!!.findViewById(R.id.floatingActionButton)

        val obj = Notes2DatabaseClass.getInstance(requireContext())
        loadMethod(obj)

        addBtn!!.setOnClickListener {
            startActivity(Intent(context,NotesCreateActivity3::class.java))
        }
        return view1
    }

    fun loadMethod(obj:Notes2DatabaseClass){
        try {
            obj.noteDao().getFavNotes().observe(viewLifecycleOwner, object:Observer<MutableList<Notes2>>{
                override fun onChanged(t: MutableList<Notes2>?) {
                    listadapter = context?.let { NotesAdapter2B(t, it) }
                    recyclerView!!.adapter = listadapter
                    FavouriteFrag().emptyTV_visibility()
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
                obj.noteDao().getFavNotes().observe(this@FavouriteFrag, object:Observer<MutableList<Notes2>>{
                    override fun onChanged(t: MutableList<Notes2>?) {
                        listadapter = context?.let { NotesAdapter2B(t, it) }
                        recyclerView!!.adapter = listadapter
                        FavouriteFrag().emptyTV_visibility()
                    }
                })
            }
            catch(e:Exception){

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
        var view1:View?=null
        var recyclerView: RecyclerView?=null
        var emptyText: TextView?=null
        var addBtn: FloatingActionButton?=null
        var favnotes:MutableList<Notes2> = mutableListOf()
        var listadapter:NotesAdapter2B?=null
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavouriteFrag().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }




}