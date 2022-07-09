package com.example.training

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception
import java.text.FieldPosition


class Fragment_Favourites : Fragment(),listCallBack {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            Companion.view1 = inflater.inflate(R.layout.fragment__favourites, container, false)

            Companion.recycler = Companion.view1!!.findViewById<RecyclerView>(R.id.recycler)
            Companion.recycler!!.layoutManager = GridLayoutManager(context, 2)

        return Companion.view1
    }

    override fun refresh(obj: BookHelperClass) {
        if(obj.isFav){
            try {
                Companion.fav_List.add(obj)
                Companion.recycler!!.adapter = Books_Adapter2(Companion.fav_List)
                Companion.recycler!!.adapter!!.notifyDataSetChanged()
            }
            catch(e:Exception){
                Companion.recycler = Companion.view1!!.findViewById<RecyclerView>(R.id.recycler)
                Companion.fav_List.add(obj)
                Companion.recycler!!.adapter = Books_Adapter2(Companion.fav_List)
                Companion.recycler!!.adapter!!.notifyDataSetChanged()
            }
        }
        else{
            try {
                Companion.fav_List.remove(obj)
                Companion.recycler!!.adapter = Books_Adapter2(Companion.fav_List)
                Companion.recycler!!.adapter!!.notifyDataSetChanged()
            }
            catch(e:Exception){
                Companion.recycler = Companion.view1!!.findViewById<RecyclerView>(R.id.recycler)
                Companion.fav_List.remove(obj)
                Companion.recycler!!.adapter = Books_Adapter2(Companion.fav_List)
                Companion.recycler!!.adapter!!.notifyDataSetChanged()
            }
        }
    }

    companion object {
        var view1:View?=null
        var recycler: RecyclerView?=null
        val fav_List=ArrayList<BookHelperClass>()
    }
}